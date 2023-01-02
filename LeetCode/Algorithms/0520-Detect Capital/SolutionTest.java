import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Detect Capital 예제 1번 테스트")
    void detectCapitalUse_example_1_test() {
        // given
        String input = "USA";
        boolean output = true;

        // when
        boolean result = SOLUTION.detectCapitalUse(input);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Detect Capital 예제 2번 테스트")
    void detectCapitalUse_example_2_test() {
        // given
        String input = "FlaG";
        boolean output = false;

        // when
        boolean result = SOLUTION.detectCapitalUse(input);

        // then
        assertEquals(output, result);
    }
}
