import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Remove Duplicates from Sorted Array 예제 1번 테스트")
    void removeDuplicates_example_1_test() {
        // given
        int[] input = {1, 1, 2};
        int outputK = 2;
        int[] outputExpectedNums = {1, 2};

        // when
        int result = SOLUTION.removeDuplicates(input);

        // then
        assertEquals(outputK, result);

        for (int i = 0; i < result; i++) {
            assertEquals(input[i], outputExpectedNums[i]);
        }
    }

    @Test
    @DisplayName("Remove Duplicates from Sorted Array 예제 2번 테스트")
    void removeDuplicates_example_2_test() {
        // given
        int[] input = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int outputK = 5;
        int[] outputExpectedNums = {0, 1, 2, 3, 4};

        // when
        int result = SOLUTION.removeDuplicates(input);

        // then
        assertEquals(outputK, result);

        for (int i = 0; i < result; i++) {
            assertEquals(input[i], outputExpectedNums[i]);
        }
    }

    @Test
    @DisplayName("Remove Duplicates from Sorted Array 추가 1번 테스트")
    void removeDuplicates_add_1_test() {
        // given
        int[] input = {-3, -1, 0, 0, 0, 3, 3};
        int outputK = 4;
        int[] outputExpectedNums = {-3, -1, 0, 3};

        // when
        int result = SOLUTION.removeDuplicates(input);

        // then
        assertEquals(outputK, result);

        for (int i = 0; i < result; i++) {
            assertEquals(input[i], outputExpectedNums[i]);
        }
    }
}
