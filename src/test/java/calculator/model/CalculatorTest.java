package calculator.model;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    void 덧셈_테스트() {
        // given
        Calculator calculator = Calculator.getInstance();
        calculator.reset();

        // when
        calculator.addCalculatorEntry("1");
        calculator.addCalculatorEntry("2");
        calculator.addCalculatorEntry("3");

        // then
        assertEquals(BigInteger.valueOf(6), calculator.getResult());
    }

    @Test
    void 사용자_정의_구분자_테스트() {
        // given
        Calculator calculator = Calculator.getInstance();
        calculator.reset();
        calculator.addCustomSet("#");

        // when
        calculator.parsingCalculatorInput("4#5#6");

        // then
        assertEquals(BigInteger.valueOf(15), calculator.getResult());
    }

    @Test
    void 입력_없음_테스트() {
        // given
        Calculator calculator = Calculator.getInstance();
        calculator.reset();

        // when
        calculator.parsingCalculatorInput("");

        // then
        assertEquals(BigInteger.valueOf(0), calculator.getResult());
    }
}
