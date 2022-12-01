import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Fibonacci Number 예제 1번 테스트")
    void fib_example_1_test() {
        // given
        int input = 2;
        int output = 1;

        // when
        int result = SOLUTION.fib(input);

        // then
        assertEquals(result, output);
    }

    @Test
    @DisplayName("Fibonacci Number 예제 2번 테스트")
    void fib_example_2_test() {
        // given
        int input = 3;
        int output = 2;

        // when
        int result = SOLUTION.fib(input);

        // then
        assertEquals(result, output);
    }

    @Test
    @DisplayName("Fibonacci Number 예제 3번 테스트")
    void fib_example_3_test() {
        // given
        int input = 4;
        int output = 3;

        // when
        int result = SOLUTION.fib(input);

        // then
        assertEquals(result, output);
    }
}
