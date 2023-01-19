import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Subarray Sums Divisible by K 예제 1번 테스트")
    void subarraysDivByK_example_1_test() {
        // given
        int[] inputNums = {4, 5, 0, -2, -3, 1};
        int inputK = 5;
        int output = 7;

        // when
        int result = SOLUTION.subarraysDivByK(inputNums, inputK);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Subarray Sums Divisible by K 예제 2번 테스트")
    void subarraysDivByK_example_2_test() {
        // given
        int[] inputNums = {5};
        int inputK = 9;
        int output = 0;

        // when
        int result = SOLUTION.subarraysDivByK(inputNums, inputK);

        // then
        assertEquals(output, result);
    }
}
