package framework;

import framework.exceptions.BeanConfigurationException;
import framework.exceptions.EnumNotFoundException;
import framework.exceptions.EnumQualifierNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.naming.ConfigurationException;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Configuration
public abstract class BeanFactory<T, E extends Enum<E>> {
    private Class<T> type;
    private Class<E> eType;

    @Autowired
    private List<T> beans;

    @Autowired
    private Environment environment;

    public BeanFactory(Class<T> type, Class<E> eType) {
        this.type = type;
        this.eType = eType;
    }

    public T get() throws ConfigurationException {
        String config = environment.getProperty(type.getName());

         return beans.stream()
                .filter(beans -> beans.getClass().getName()
                        .equals(config))
                .findFirst()
                .orElseThrow(() -> new BeanConfigurationException(type, config));
    }

    public List<T> getAll() {
        return this.beans;
    }

    public Map<E, T> getMap() {
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
