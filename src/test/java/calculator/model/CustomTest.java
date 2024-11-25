package calculator.model;

import calculator.constants.DelimiterConstants;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomTest {

    @Test
    void 초기_구분자_테스트() {
        // given
        Custom custom = new Custom();

        // when
        Set<String> customSet = custom.getCustomSet();

        // then
        assertTrue(customSet.contains(DelimiterConstants.INITIAL_CUSTOM_COLON.getMessage()));
        assertTrue(customSet.contains(DelimiterConstants.INITIAL_CUSTOM_COMMA.getMessage()));
    }

    @Test
    void 사용자_정의_구분자_추가_테스트() {
        // given
        Custom custom = new Custom();

        // when
        custom.addCustomSet("#");

        // then
        assertTrue(custom.getCustomSet().contains("#"));
    }

    @Test
    void 리셋_후_초기화_테스트() {
        // given
        Custom custom = new Custom();
        custom.addCustomSet("#");

        // when
        custom.resetCustomSet();
        Set<String> customSet = custom.getCustomSet();

        // then
        assertTrue(customSet.contains(DelimiterConstants.INITIAL_CUSTOM_COLON.getMessage()));
        assertTrue(customSet.contains(DelimiterConstants.INITIAL_CUSTOM_COMMA.getMessage()));
        assertTrue(!customSet.contains("#"));
    }
}
