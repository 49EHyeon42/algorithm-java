import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    @DisplayName("Binary Search 예제 1번 테스트")
    void search_example_1_test() {
        Solution solution = new Solution();

        // given
        int[] inputNums = {-1, 0, 3, 5, 9, 12};
        int inputTarget = 9;
        int output = 4;

        // when
        int result = solution.search(inputNums, inputTarget);

        // then
        assertEquals(result, output);
    }

    @Test
    @DisplayName("Binary Search 예제 2번 테스트")
    void search_example_2_test() {
        Solution solution = new Solution();

        // given
        int[] inputNums = {-1, 0, 3, 5, 9, 12};
        int inputTarget = 2;
        int output = -1;

        // when
        int result = solution.search(inputNums, inputTarget);

        // then
        assertEquals(result, output);
    }
}
