import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Richest Customer Wealth 예제 1번 테스트")
    void maximumWealth_example_1_test() {
        // given
        int[][] input = {{1, 2, 3}, {3, 2, 1}};
        int output = 6;

        // when
        int result = SOLUTION.maximumWealth(input);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Richest Customer Wealth 예제 2번 테스트")
    void maximumWealth_example_2_test() {
        // given
        int[][] input = {{1, 5}, {7, 3}, {3, 5}};
        int output = 10;

        // when
        int result = SOLUTION.maximumWealth(input);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Richest Customer Wealth 예제 3번 테스트")
    void maximumWealth_example_3_test() {
        // given
        int[][] input = {{2, 8, 7}, {7, 1, 3}, {1, 9, 5}};
        int output = 17;

        // when
        int result = SOLUTION.maximumWealth(input);

        // then
        assertEquals(output, result);
    }
}
