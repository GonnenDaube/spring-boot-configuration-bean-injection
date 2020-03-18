package framework;

import framework.exceptions.BeanConfigurationException;
import framework.exceptions.EnumNotFoundException;
import framework.exceptions.EnumQualifierNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Configuration
public abstract class BeanFactory<T, E extends Enum<E>> {
    private Class<T> type;
    private Class<E> eType;

    public static final String CONF = UUID.randomUUID().toString();
    public static final String IMPLS = UUID.randomUUID().toString();
    public static final String MAP = UUID.randomUUID().toString();

    @Autowired
    private ApplicationContext context;

    @Autowired
    private List<T> beans;

    @Autowired
    private Environment environment;

    public BeanFactory(Class<T> type, Class<E> eType) {
        this.type = type;
        this.eType = eType;
    }

    @PostConstruct
    public void init() {
        T configurationBean = getConfigurationBean();
        List<T> implementations = getAll();
        Map<E, T> map = getMap();

        AutowireCapableBeanFactory factory = context.getAutowireCapableBeanFactory();
        factory.initializeBean(configurationBean, CONF);
        factory.initializeBean(implementations, IMPLS);
        factory.initializeBean(map, MAP);
    }

    private T getConfigurationBean() {
        String config = environment.getProperty(type.getName());

         return beans.stream()
                .filter(beans -> beans.getClass().getName()
                        .equals(config))
                .findFirst()
                .orElseThrow(() -> new BeanConfigurationException(type, config));
    }

    private List<T> getAll() {
        return this.beans;
    }

    private Map<E, T> getMap() {
        EnumMap<E, T> map = new EnumMap<E, T>(eType);
        this.beans.forEach(bean -> map.put(getEnum(bean), bean));

        return map;
    }

    private E getEnum(T bean) {
        String value = "";

        try {
            EnumQualifier qualifier = bean.getClass().getDeclaredAnnotation(EnumQualifier.class);
            if (qualifier == null)
                throw new EnumQualifierNotFoundException(bean.getClass());
            value = qualifier.value();

            return E.valueOf(eType, value);
        } catch (IllegalArgumentException e) {
            throw new EnumNotFoundException(eType, value, e);
        }
    }
}
