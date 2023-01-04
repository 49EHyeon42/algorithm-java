import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Minimum Rounds to Complete All Tasks 예제 1번 테스트")
    void minimumRounds_example_1_test() {
        // given
        int[] input = {2, 2, 3, 3, 2, 4, 4, 4, 4, 4};
        int output = 4;

        // when
        int result = SOLUTION.minimumRounds(input);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Minimum Rounds to Complete All Tasks 예제 2번 테스트")
    void minimumRounds_example_2_test() {
        // given
        int[] input = {2, 3, 3};
        int output = -1;

        // when
        int result = SOLUTION.minimumRounds(input);

        // then
        assertEquals(output, result);
    }
}
