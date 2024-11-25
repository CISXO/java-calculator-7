package calculator.utils;

import calculator.constants.ErrorMessage;

public class AddEntryValidator {

    public void validateNumericEntry(String entry) {
        if (!entry.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.ADDENTRY_NOT_NUMERIC.getMessage());
        }
    }

}
