import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    @DisplayName("Best Time to Buy and Sell Stock 예제 1번 테스트")
    void maxProfit_example_1_test() {
        Solution solution = new Solution();

        // given
        int[] input = {7, 1, 5, 3, 6, 4};
        int output = 5;

        // when
        int result = solution.maxProfit(input);

        // then
        assertEquals(result, output);
    }

    @Test
    @DisplayName("Best Time to Buy and Sell Stock 예제 2번 테스트")
    void maxProfit_example_2_test() {
        Solution solution = new Solution();

        // given
        int[] input = {7, 6, 4, 3, 1};
        int output = 0;

        // when
        int result = solution.maxProfit(input);

        // then
        assertEquals(result, output);
    }
}
