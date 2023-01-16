import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Insert Interval 예제 1번 테스트")
    void insert_example_1_test() {
        // given
        int[][] inputIntervals = {{1, 3}, {6, 9}};
        int[] inputNewInterval = {2, 5};
        int[][] output = {{1, 5}, {6, 9}};

        // when
        int[][] result = SOLUTION.insert(inputIntervals, inputNewInterval);

        // then
        assertTrue(Arrays.deepEquals(output, result));
    }

    @Test
    @DisplayName("Insert Interval 예제 2번 테스트")
    void insert_example_2_test() {
        // given
        int[][] inputIntervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] inputNewInterval = {4, 8};
        int[][] output = {{1, 2}, {3, 10}, {12, 16}};

        // when
        int[][] result = SOLUTION.insert(inputIntervals, inputNewInterval);

        // then
        assertTrue(Arrays.deepEquals(output, result));
    }
}
