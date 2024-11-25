package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Calculator calculator;

    public CalculatorController(Calculator calculator) {
        this.calculator = calculator;
    }

    public void run() {
        try {
            process(this::readInput);
            process(this::addCustomSet);
            process(this::parsingCalculatorInput);
            process(this::calculateResult);
        } finally {
            resetCalculator();
        }
    }

    private void resetCalculator() {
        calculator.reset();
    }

    private void calculateResult() {
        outputView.printCalculatorResultMessage(calculator.getResult());
    }

    private void parsingCalculatorInput() {
        calculator.parsingCalculatorInput(inputView.getInputString());
    }

    private void addCustomSet() {
        calculator.addCustomSet(inputView.getCustom());
    }

    private void readInput() {
        outputView.printReadNumberMessage();
        inputView.readInputString();
    }

    private void process(Runnable action) {
        try {
            action.run();
        } catch (IllegalArgumentException e) {
            outputView.exception(e);
            throw e;
        }
    }

}
