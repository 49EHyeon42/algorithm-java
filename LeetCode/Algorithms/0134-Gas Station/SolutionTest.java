import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Gas Station 예제 1번 테스트")
    void canCompleteCircuit_example_1_test() {
        // given
        int[] inputGas = {1, 2, 3, 4, 5};
        int[] inputCost = {3, 4, 5, 1, 2};
        int output = 3;

        // when
        int result = SOLUTION.canCompleteCircuit(inputGas, inputCost);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Gas Station 예제 2번 테스트")
    void canCompleteCircuit_example_2_test() {
        // given
        int[] inputGas = {2, 3, 4};
        int[] inputCost = {3, 4, 3};
        int output = -1;

        // when
        int result = SOLUTION.canCompleteCircuit(inputGas, inputCost);

        // then
        assertEquals(output, result);
    }
}
