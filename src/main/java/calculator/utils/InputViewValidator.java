package calculator.utils;

import calculator.constants.ErrorMessage;

public class InputViewValidator {

    public void validateCustomNumeric(String customData) {
        if (customData.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.CUSTOM_NOT_CHAR.getMessage());
        }
    }

}