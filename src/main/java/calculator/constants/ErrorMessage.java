package calculator.constants;

public enum ErrorMessage {
    CUSTOM_NOT_CHAR("커스텀 값에 숫자는 허용하지 않습니다."),
    EMPTY_CUSTOM("구분자는 비어 있을 수 없습니다."),
    INVALID_NUMBER("유효하지 않은 숫자입니다."),
    ADDENTRY_NOT_NUMERIC("계산을 위한 입력값이 숫자가 아닙니다."),
    GENERIC_ERROR("알 수 없는 오류가 발생했습니다.");

    private static final String ERROR_PREFIX = "Error: ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
