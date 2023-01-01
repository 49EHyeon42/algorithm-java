import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Happy Number 예제 1번 테스트")
    void isHappy_example_1_test() {
        // given
        int input = 19;
        boolean output = true;

        // when
        boolean result = SOLUTION.isHappy(input);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Happy Number 예제 2번 테스트")
    void isHappy_example_2_test() {
        // given
        int input = 2;
        boolean output = false;

        // when
        boolean result = SOLUTION.isHappy(input);

        // then
        assertEquals(output, result);
    }
}
