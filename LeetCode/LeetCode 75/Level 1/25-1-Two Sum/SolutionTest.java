import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Two Sum 예제 1번 테스트")
    void twoSum_example_1_test() {
        // given
        int[] inputNums = {2, 7, 11, 15};
        int inputTarget = 9;
        int[] output = {0, 1};

        // when
        int[] result = SOLUTION.twoSum(inputNums, inputTarget);

        // then
        assertArrayEquals(output, result);
    }

    @Test
    @DisplayName("Two Sum 예제 2번 테스트")
    void twoSum_example_2_test() {
        // given
        int[] inputNums = {3, 2, 4};
        int inputTarget = 6;
        int[] output = {1, 2};

        // when
        int[] result = SOLUTION.twoSum(inputNums, inputTarget);

        // then
        assertArrayEquals(output, result);
    }

    @Test
    @DisplayName("Two Sum 예제 3번 테스트")
    void twoSum_example_3_test() {
        // given
        int[] inputNums = {3, 3};
        int inputTarget = 6;
        int[] output = {0, 1};

        // when
        int[] result = SOLUTION.twoSum(inputNums, inputTarget);

        // then
        assertArrayEquals(output, result);
    }
}
