import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Word Pattern 예제 1번 테스트")
    void wordPattern_example_1_test() {
        // given
        String inputPattern = "abba";
        String inputS = "dog cat cat dog";
        boolean output = true;

        // when
        boolean result = SOLUTION.wordPattern(inputPattern, inputS);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Word Pattern 예제 2번 테스트")
    void wordPattern_example_2_test() {
        // given
        String inputPattern = "abba";
        String inputS = "dog cat cat fish";
        boolean output = false;

        // when
        boolean result = SOLUTION.wordPattern(inputPattern, inputS);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Word Pattern 예제 3번 테스트")
    void wordPattern_example_3_test() {
        // given
        String inputPattern = "aaaa";
        String inputS = "dog cat cat dog";
        boolean output = false;

        // when
        boolean result = SOLUTION.wordPattern(inputPattern, inputS);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Word Pattern 추가 1번 테스트")
    void wordPattern_add_1_test() {
        // given
        String inputPattern = "abba";
        String inputS = "dog dog dog dog";
        boolean output = false;

        // when
        boolean result = SOLUTION.wordPattern(inputPattern, inputS);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Word Pattern 추가 2번 테스트")
    void wordPattern_add_2_test() {
        // given
        String inputPattern = "aaa";
        String inputS = "aa aa aa aa";
        boolean output = false;

        // when
        boolean result = SOLUTION.wordPattern(inputPattern, inputS);

        // then
        assertEquals(output, result);
    }
}
