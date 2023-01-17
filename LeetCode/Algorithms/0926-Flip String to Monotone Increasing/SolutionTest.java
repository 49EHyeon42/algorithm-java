import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Flip String to Monotone Increasing 예제 1번 테스트")
    void minFlipsMonoIncr_example_1_test() {
        // given
        String input = "00110";
        int output = 1;

        // when
        int result = SOLUTION.minFlipsMonoIncr(input);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Flip String to Monotone Increasing 예제 2번 테스트")
    void minFlipsMonoIncr_example_2_test() {
        // given
        String input = "010110";
        int output = 2;

        // when
        int result = SOLUTION.minFlipsMonoIncr(input);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Flip String to Monotone Increasing 예제 3번 테스트")
    void minFlipsMonoIncr_example_3_test() {
        // given
        String input = "00011000";
        int output = 2;

        // when
        int result = SOLUTION.minFlipsMonoIncr(input);

        // then
        assertEquals(output, result);
    }
}
