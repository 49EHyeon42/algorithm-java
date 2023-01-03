import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Delete Columns to Make Sorted 예제 1번 테스트")
    void minDeletionSize_example_1_test() {
        // given
        String[] input = {"cba", "daf", "ghi"};
        int output = 1;

        // when
        int result = SOLUTION.minDeletionSize(input);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Delete Columns to Make Sorted 예제 2번 테스트")
    void minDeletionSize_example_2_test() {
        // given
        String[] input = {"a", "b"};
        int output = 0;

        // when
        int result = SOLUTION.minDeletionSize(input);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Delete Columns to Make Sorted 예제 3번 테스트")
    void minDeletionSize_example_3_test() {
        // given
        String[] input = {"zyx", "wvu", "tsr"};
        int output = 3;

        // when
        int result = SOLUTION.minDeletionSize(input);

        // then
        assertEquals(output, result);
    }
}
