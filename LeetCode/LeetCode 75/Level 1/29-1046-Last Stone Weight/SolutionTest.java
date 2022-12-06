import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Last Stone Weight 예제 1번 테스트")
    void lastStoneWeight_example_1_test() {
        // given
        int[] input = {2, 7, 4, 1, 8, 1};
        int output = 1;

        // when
        int result = SOLUTION.lastStoneWeight(input);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Last Stone Weight 예제 2번 테스트")
    void lastStoneWeight_example_2_test() {
        // given
        int[] input = {1};
        int output = 1;

        // when
        int result = SOLUTION.lastStoneWeight(input);

        // then
        assertEquals(output, result);
    }
}
