import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Valid Parentheses 예제 1번 테스트")
    void isValid_example_1_test() {
        // given
        String input = "()";
        boolean output = true;

        // when
        boolean result = SOLUTION.isValid(input);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Valid Parentheses 예제 2번 테스트")
    void isValid_example_2_test() {
        // given
        String input = "()[]{}";
        boolean output = true;

        // when
        boolean result = SOLUTION.isValid(input);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Valid Parentheses 예제 3번 테스트")
    void isValid_example_3_test() {
        // given
        String input = "(]";
        boolean output = false;

        // when
        boolean result = SOLUTION.isValid(input);

        // then
        assertEquals(output, result);
    }
}
