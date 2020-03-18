package framework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.naming.ConfigurationException;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public abstract class ConfigurationBeanFactory<T, E extends Enum<E>> {
    private Class<T> type;
    private Class<E> eType;

    @Autowired
    private List<T> beans;

    @Autowired
    private Environment environment;

    public ConfigurationBeanFactory(Class<T> type, Class<E> eType) {
        this.type = type;
        this.eType = eType;
    }

    public T get() throws ConfigurationException {
         return beans.stream()
                .filter(beans -> beans.getClass().getName()
                        .equals(environment.getProperty(type.getName())))
                .findFirst()
                .orElseThrow(ConfigurationException::new);
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
        String name = bean.getClass().getName();
        name = name.toUpperCase().replaceAll("[.]", "_");

        return E.valueOf(eType, name);
    }
}
