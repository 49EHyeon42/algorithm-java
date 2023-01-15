import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Number of Good Paths 예제 1번 테스트")
    void numberOfGoodPaths_example_1_test() {
        // given
        int[] inputVals = {1, 3, 2, 1, 3};
        int[][] inputEdges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}};
        int output = 6;

        // when
        int result = SOLUTION.numberOfGoodPaths(inputVals, inputEdges);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Number of Good Paths 예제 2번 테스트")
    void numberOfGoodPaths_example_2_test() {
        // given
        int[] inputVals = {1, 1, 2, 2, 3};
        int[][] inputEdges = {{0, 1}, {1, 2}, {2, 3}, {2, 4}};
        int output = 7;

        // when
        int result = SOLUTION.numberOfGoodPaths(inputVals, inputEdges);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Number of Good Paths 예제 3번 테스트")
    void numberOfGoodPaths_example_3_test() {
        // given
        int[] inputVals = {1};
        int[][] inputEdges = {};
        int output = 1;

        // when
        int result = SOLUTION.numberOfGoodPaths(inputVals, inputEdges);

        // then
        assertEquals(output, result);
    }
}
