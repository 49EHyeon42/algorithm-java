import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Subarray Product Less Than K 예제 1번 테스트")
    void numSubarrayProductLessThanK_example_1_test() {
        // given
        int[] inputNums = {10, 5, 2, 6};
        int inputK = 100;
        int output = 8;

        // when
        int result = SOLUTION.numSubarrayProductLessThanK(inputNums, inputK);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Subarray Product Less Than K 예제 2번 테스트")
    void numSubarrayProductLessThanK_example_2_test() {
        // given
        int[] inputNums = {1, 2, 3};
        int inputK = 0;
        int output = 0;

        // when
        int result = SOLUTION.numSubarrayProductLessThanK(inputNums, inputK);

        // then
        assertEquals(output, result);
    }
}
