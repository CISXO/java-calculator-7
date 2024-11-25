package calculator.model;

import calculator.constants.DelimiterConstants;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CustomTest {
    @Test
    void 초기_구분자_테스트() {
        // Arrange
        Custom custom = new Custom();

        // Act
        Set<String> customSet = custom.getCustomSet();

        // Assert
        assertTrue(customSet.contains(DelimiterConstants.INITIAL_CUSTOM_COLON.getMessage()));
        assertTrue(customSet.contains(DelimiterConstants.INITIAL_CUSTOM_COMMA.getMessage()));
    }

    @Test
    void 사용자_정의_구분자_추가_테스트() {
        // Arrange
        Custom custom = new Custom();

        // Act
        custom.addCustomSet("#");

        // Assert
        assertTrue(custom.getCustomSet().contains("#"));
    }

    @Test
    void 리셋_후_초기화_테스트() {
        // Arrange
        Custom custom = new Custom();

        // Act
        custom.addCustomSet("#");
        custom.resetCustomSet();
        Set<String> customSet = custom.getCustomSet();

        // Assert
        assertTrue(customSet.contains(DelimiterConstants.INITIAL_CUSTOM_COLON.getMessage()));
        assertTrue(customSet.contains(DelimiterConstants.INITIAL_CUSTOM_COMMA.getMessage()));
        assertTrue(!customSet.contains("#"));
    }

}