import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Search Insert Position 예제 1번 테스트")
    void searchInsert_example_1_test() {
        // given
        int[] inputNums = {1, 3, 5, 6};
        int inputTarget = 5;
        int output = 2;

        // when
        int result = SOLUTION.searchInsert(inputNums, inputTarget);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Search Insert Position 예제 2번 테스트")
    void searchInsert_example_2_test() {
        // given
        int[] inputNums = {1, 3, 5, 6};
        int inputTarget = 2;
        int output = 1;

        // when
        int result = SOLUTION.searchInsert(inputNums, inputTarget);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Search Insert Position 예제 3번 테스트")
    void searchInsert_example_3_test() {
        // given
        int[] inputNums = {1, 3, 5, 6};
        int inputTarget = 7;
        int output = 4;

        // when
        int result = SOLUTION.searchInsert(inputNums, inputTarget);

        // then
        assertEquals(output, result);
    }
}
