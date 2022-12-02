import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Min Cost Climbing Stairs 예제 1번 테스트")
    void minCostClimbingStairs_example_1_test() {
        // given
        int[] input = {10, 15, 20};
        int output = 15;

        // when
        int result = SOLUTION.minCostClimbingStairs(input);

        // then
        assertEquals(result, output);
    }

    @Test
    @DisplayName("Min Cost Climbing Stairs 예제 2번 테스트")
    void minCostClimbingStairs_example_2_test() {
        // given
        int[] input = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int output = 6;

        // when
        int result = SOLUTION.minCostClimbingStairs(input);

        // then
        assertEquals(result, output);
    }
}
