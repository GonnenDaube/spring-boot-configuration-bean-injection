package framework.exceptions;

import java.text.MessageFormat;

public class EnumQualifierNotFoundException extends RuntimeException {

    Class<?> clazz;

    public EnumQualifierNotFoundException(Class<?> clazz) {
        super();
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return MessageFormat.format(ExceptionMessage.NO_ENUM_QUALIFIER_FOUND.message, clazz.getName());
    }
}
