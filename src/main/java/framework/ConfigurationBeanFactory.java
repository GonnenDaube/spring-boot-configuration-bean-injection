package framework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.naming.ConfigurationException;
import java.util.List;

@Configuration
public abstract class ConfigurationBeanFactory<T> {
    @Autowired
    private List<T> beans;

    @Autowired
    private Environment environment;

    public T getBean(Class<T> type) throws ConfigurationException {
         return beans.stream()
                .filter(beans -> beans.getClass().getName()
                        .equals(environment.getProperty(type.getName())))
                .findFirst()
                .orElseThrow(ConfigurationException::new);
    }

    /**
     * simple usage in subclass:
     *  @Override
     *  @Bean(name=T.NAME)
     *  public T get() throws Exception {
     *      return getBean(T.class);
     *  }
     */
    public abstract T get() throws ConfigurationException;
}
