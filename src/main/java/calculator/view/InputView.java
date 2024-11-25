package calculator.view;

import calculator.constants.DelimiterConstants;
import calculator.constants.InputConstants;
import calculator.utils.InputViewValidator;
import camp.nextstep.edu.missionutils.Console;


public class InputView {

    private final InputViewValidator inputViewValidator = new InputViewValidator();

    private String inputName;
    private String customData;

    public void readInputString() {
        inputName = Console.readLine();
        resultInput();
    }

    public String getCustom() {
        return customData;
    }

    public String getInputString() {
        return inputName;
    }

    private void resultInput() {
        if (isCustom()) {
            inputName = inputName.substring(InputConstants.SUBSTRING_BIASIS.getValue());
        }
    }

    private Boolean isCustom() {
        if (!hasInputCustomLength() || !hasCustomDelimeter()) {
            return false;
        }

        inputViewValidator.validateCustomNumeric(getParsingCustom());
        setCustom(getParsingCustom());

        return true;
    }

    private void setCustom(String customData) {
        this.customData = customData;
    }

    private boolean hasInputCustomLength() {
        return inputName.length() >= InputConstants.SUBSTRING_BIASIS.getValue();
    }

    private boolean hasCustomDelimeter() {
        String prefix = inputName.substring(InputConstants.PREFIX_START_DIGIT.getValue(), InputConstants.PREFIX_END_DIGIT.getValue());
        String suffix = inputName.substring(InputConstants.SUBFIX_START_DIGIT.getValue(), InputConstants.SUBFIX_END_DIGIT.getValue());
        return prefix.equals(DelimiterConstants.DELIMITER_START_ENTRY.getMessage()) && suffix.equals(DelimiterConstants.DELIMITER_END_ENTRY.getMessage());
    }

    private String getParsingCustom() {
        return inputName.substring(InputConstants.PREFIX_END_DIGIT.getValue(), InputConstants.SUBFIX_START_DIGIT.getValue());
    }

}