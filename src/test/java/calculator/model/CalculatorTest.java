package calculator.model;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void 덧셈_테스트() {
        // Arrange
        Calculator calculator = Calculator.getInstance();
        calculator.reset();

        // Act
        calculator.addCalculatorEntry("1");
        calculator.addCalculatorEntry("2");
        calculator.addCalculatorEntry("3");

        // Assert
        assertEquals(BigInteger.valueOf(6), calculator.getResult());
    }

    @Test
    void 사용자_정의_구분자_테스트() {
        // Arrange
        Calculator calculator = Calculator.getInstance();
        calculator.reset();

        // Act
        calculator.addCustomSet("#");
        calculator.parsingCalculatorInput("4#5#6");

        // Assert
        assertEquals(BigInteger.valueOf(15), calculator.getResult());
    }

    @Test
    void 입력_없음_테스트() {
        // Arrange
        Calculator calculator = Calculator.getInstance();
        calculator.reset();

        // Act
        calculator.parsingCalculatorInput("");

        // Assert
        assertEquals(BigInteger.valueOf(0), calculator.getResult());
    }

}