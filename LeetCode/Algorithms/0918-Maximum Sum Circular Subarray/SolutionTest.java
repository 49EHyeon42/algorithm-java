import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Maximum Sum Circular Subarray 예제 1번 테스트")
    void maxSubarraySumCircular_example_1_test() {
        // given
        int[] input = {1, -2, 3, -2};
        int output = 3;

        // when
        int result = SOLUTION.maxSubarraySumCircular(input);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Maximum Sum Circular Subarray 예제 2번 테스트")
    void maxSubarraySumCircular_example_2_test() {
        // given
        int[] input = {5, -3, 5};
        int output = 10;

        // when
        int result = SOLUTION.maxSubarraySumCircular(input);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Maximum Sum Circular Subarray 예제 3번 테스트")
    void maxSubarraySumCircular_example_3_test() {
        // given
        int[] input = {-3, -2, -3};
        int output = -2;

        // when
        int result = SOLUTION.maxSubarraySumCircular(input);

        // then
        assertEquals(output, result);
    }
}
