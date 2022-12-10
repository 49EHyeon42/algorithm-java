import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Number of Steps to Reduce a Number to Zero 예제 1번 테스트")
    void numberOfSteps_example_1_test() {
        // given
        int input = 14;
        int output = 6;

        // when
        int result = SOLUTION.numberOfSteps(input);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Number of Steps to Reduce a Number to Zero 예제 2번 테스트")
    void numberOfSteps_example_2_test() {
        // given
        int input = 8;
        int output = 4;

        // when
        int result = SOLUTION.numberOfSteps(input);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Number of Steps to Reduce a Number to Zero 예제 3번 테스트")
    void numberOfSteps_example_3_test() {
        // given
        int input = 123;
        int output = 12;

        // when
        int result = SOLUTION.numberOfSteps(input);

        // then
        assertEquals(output, result);
    }
}
