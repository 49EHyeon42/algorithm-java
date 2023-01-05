import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Minimum Number of Arrows to Burst Balloons 예제 1번 테스트")
    void findMinArrowShots_example_1_test() {
        // given
        int[][] input = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int output = 2;

        // when
        int result = SOLUTION.findMinArrowShots(input);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Minimum Number of Arrows to Burst Balloons 예제 2번 테스트")
    void findMinArrowShots_example_2_test() {
        // given
        int[][] input = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        int output = 4;

        // when
        int result = SOLUTION.findMinArrowShots(input);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Minimum Number of Arrows to Burst Balloons 예제 3번 테스트")
    void findMinArrowShots_example_3_test() {
        // given
        int[][] input = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int output = 2;

        // when
        int result = SOLUTION.findMinArrowShots(input);

        // then
        assertEquals(output, result);
    }
}
