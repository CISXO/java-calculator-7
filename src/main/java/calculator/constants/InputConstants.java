package calculator.constants;

public enum InputConstants {
    SUBSTRING_BIASIS(5),
    PREFIX_START_DIGIT(0),
    PREFIX_END_DIGIT(2),
    SUBFIX_START_DIGIT(3),
    SUBFIX_END_DIGIT(5);

    private final int value;

    InputConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}