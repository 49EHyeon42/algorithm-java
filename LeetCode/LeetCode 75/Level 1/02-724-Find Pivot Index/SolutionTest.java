import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    @DisplayName("Find Pivot Index 예제 1번 테스트")
    void pivotIndex_example_1_test() {
        Solution solution = new Solution();

        // given
        int[] input = {1, 7, 3, 6, 5, 6};
        int output = 3;

        // when
        int result = solution.pivotIndex(input);

        // then
        assertEquals(result, output);
    }

    @Test
    @DisplayName("Find Pivot Index 예제 2번 테스트")
    void pivotIndex_example_2_test() {
        Solution solution = new Solution();

        // given
        int[] input = {1, 2, 3};
        int output = -1;

        // when
        int result = solution.pivotIndex(input);

        // then
        assertEquals(result, output);
    }
}
