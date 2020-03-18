package framework.exceptions;

import framework.EnumQualifier;

public enum ExceptionMessage {

    NO_ENUM_QUALIFIER_FOUND("\n[ERROR] Enum Qualifier Error: " +
            "\n\tImplementation: \"{0}\", should be annotated with " + EnumQualifier.class.getName() +
            "\n\t(HINT :: " +
            "\n\t@" + EnumQualifier.class.getSimpleName() + "(\"corresponding enum value\")" +
            "\n\tpublic class {0} ...)"),
    ENUM_NOT_FOUND("\n[ERROR] Enum Qualifier Error: " +
            "\n\tEnum Qualifier: \"{0}\" does not correspond to any enum value of type \"{1}\""),
    BEAN_CONFIG_EXCEPTION("\n[ERROR] Bean Configuration Error: " +
            "\n\tImplementation: \"{0}\" of interface: \"{1}\" does not exist. " +
            "\n\tPlease provide an existing implementation in the configuration" +
            "\n\t(HINT :: add property to application.properties ->" +
            "\n\tkey: interface''s fully qualified name" +
            "\n\tvalue: implementation''s fully qualified name)");

    public final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }
}
