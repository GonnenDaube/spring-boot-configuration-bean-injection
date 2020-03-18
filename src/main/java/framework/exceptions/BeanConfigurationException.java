package framework.exceptions;

import java.text.MessageFormat;

public class BeanConfigurationException extends RuntimeException {

    private Class<?> inter;
    private String config;

    public BeanConfigurationException(Class<?> inter, String config) {
        super();

        this.inter = inter;
        this.config = config;
    }

    @Override
    public String toString() {
        return MessageFormat.format(ExceptionMessage.BEAN_CONFIG_EXCEPTION.message, config, inter.getName());
    }
}
