package framework.exceptions;

import java.text.MessageFormat;

public class EnumNotFoundException extends RuntimeException {

    private Class<?> enumType;
    private String value;

    public EnumNotFoundException(Class<?> enumType, String value, Throwable cause) {
        super(cause);

        this.enumType = enumType;
        this.value = value;
    }

    @Override
    public String toString() {
        return MessageFormat.format(ExceptionMessage.ENUM_NOT_FOUND.message, value, enumType);
    }
}
