package calculator.model;

import calculator.constants.DelimiterConstants;
import calculator.utils.AddEntryValidator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    private static final Calculator INSTANCE = new Calculator();

    private final List<BigInteger> addEntries;
    private final AddEntryValidator addEntryValidator = new AddEntryValidator();
    private final Custom custom;

    private Calculator() {
        this.addEntries = new ArrayList<>();
        this.custom = new Custom();
    }

    public static Calculator getInstance() {
        return INSTANCE;
    }

    public void addCustomSet(String customData) {
        custom.addCustomSet(customData);
    }

    public void addCalculatorEntry(String entry) {
        addEntries.add(new BigInteger(entry));
    }

    public BigInteger calculateSum() {
        return addEntries.stream()
                .reduce(BigInteger.ZERO, BigInteger::add);
    }

    public BigInteger getResult() {
        return calculateSum();
    }

    public void parsingCalculatorInput(String parsingInputString) {
        String customDelimiters = String.join("", custom.getCustomSet());

        Arrays.stream(parsingInputString.split(DelimiterConstants.CUSTOM_PREFIX + customDelimiters + DelimiterConstants.CUSTOM_SUFFIX))
                .map(String::trim)
                .filter(entry -> !entry.isEmpty())
                .forEach(entry -> {
                    addEntryValidator.validateNumericEntry(entry);
                    addCalculatorEntry(entry);
                });
    }

    public void reset() {
        addEntries.clear();
        custom.resetCustomSet();
    }
}
