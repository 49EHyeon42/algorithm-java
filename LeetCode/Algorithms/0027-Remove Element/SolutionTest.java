import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Remove Element 예제 1번 테스트")
    void removeElement_example_1_test() {
        // given
        int[] inputNums = {3, 2, 2, 3};
        int inputVal = 3;
        int outputK = 2;
        int[] outputExpectedNums = {2, 2};

        // when
        int result = SOLUTION.removeElement(inputNums, inputVal);

        // then
        assertEquals(outputK, result);

        Arrays.sort(inputNums, 0, outputK);

        for (int i = 0; i < result; i++) {
            assertEquals(inputNums[i], outputExpectedNums[i]);
        }
    }

    @Test
    @DisplayName("Remove Element 예제 2번 테스트")
    void removeElement_example_2_test() {
        // given
        int[] inputNums = {0, 1, 2, 2, 3, 0, 4, 2};
        int inputVal = 2;
        int outputK = 5;
        int[] outputExpectedNums = {0, 0, 1, 3, 4};

        // when
        int result = SOLUTION.removeElement(inputNums, inputVal);

        // then
        assertEquals(outputK, result);

        Arrays.sort(inputNums, 0, outputK);

        for (int i = 0; i < result; i++) {
            assertEquals(inputNums[i], outputExpectedNums[i]);
        }
    }
}
