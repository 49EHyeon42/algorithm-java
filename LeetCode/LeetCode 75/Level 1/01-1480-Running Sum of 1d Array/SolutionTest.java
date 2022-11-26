import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    @DisplayName("Running Sum of 1d Array 예제 1번 테스트")
    void runningSum_example_1_test() {
        Solution solution = new Solution();

        // given
        int[] input = {1, 2, 3, 4};
        int[] output = {1, 3, 6, 10};

        // when
        int[] result = solution.runningSum(input);

        // then
        assertArrayEquals(result, output);
    }

    @Test
    @DisplayName("Running Sum of 1d Array 예제 2번 테스트")
    void runningSum_example_2_test() {
        Solution solution = new Solution();

        // given
        int[] input = {1, 1, 1, 1, 1};
        int[] output = {1, 2, 3, 4, 5};

        // when
        int[] result = solution.runningSum(input);

        // then
        assertArrayEquals(result, output);
    }

    @Test
    @DisplayName("Running Sum of 1d Array 예제 3번 테스트")
    void runningSum_example_3_test() {
        Solution solution = new Solution();

        // given
        int[] input = {3, 1, 2, 10, 1};
        int[] output = {3, 4, 6, 16, 17};

        // when
        int[] result = solution.runningSum(input);

        // then
        assertArrayEquals(result, output);
    }
}
