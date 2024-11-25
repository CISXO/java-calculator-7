package calculator.constants;

public enum DelimiterConstants {
    INITIAL_CUSTOM_COLON(":"),
    INITIAL_CUSTOM_COMMA(","),
    DELIMITER_START_ENTRY("//"),
    DELIMITER_END_ENTRY("\\n"),
    CUSTOM_PREFIX("["),
    CUSTOM_SUFFIX("]");

    private final String message;

    DelimiterConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
