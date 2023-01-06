import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Maximum Ice Cream Bars 예제 1번 테스트")
    void maxIceCream_example_1_test() {
        // given
        int[] inputCosts = {1, 3, 2, 4, 1};
        int inputCoins = 7;
        int output = 4;

        // when
        int result = SOLUTION.maxIceCream(inputCosts, inputCoins);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Maximum Ice Cream Bars 예제 2번 테스트")
    void maxIceCream_example_2_test() {
        // given
        int[] inputCosts = {10, 6, 8, 7, 7, 8};
        int inputCoins = 5;
        int output = 0;

        // when
        int result = SOLUTION.maxIceCream(inputCosts, inputCoins);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Maximum Ice Cream Bars 예제 3번 테스트")
    void maxIceCream_example_3_test() {
        // given
        int[] inputCosts = {1, 6, 3, 1, 2, 5};
        int inputCoins = 20;
        int output = 6;

        // when
        int result = SOLUTION.maxIceCream(inputCosts, inputCoins);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Maximum Ice Cream Bars 추가 1번 테스트")
    void maxIceCream_add_1_test() {
        // given
        int[] inputCosts = {7, 3, 3, 6, 6, 6, 10, 5, 9, 2};
        int inputCoins = 56;
        int output = 9;

        // when
        int result = SOLUTION.maxIceCream(inputCosts, inputCoins);

        // then
        assertEquals(output, result);
    }
}
