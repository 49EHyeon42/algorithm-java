import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Climbing Stairs 예제 1번 테스트")
    void climbStairs_example_1_test() {
        // given
        int input = 2;
        int output = 2;
        
        // when
        int result = SOLUTION.climbStairs(input);

        // then
        assertEquals(result, output);
    }

    @Test
    @DisplayName("Climbing Stairs 예제 2번 테스트")
    void climbStairs_example_2_test() {
        // given
        int input = 3;
        int output = 3;

        // when
        int result = SOLUTION.climbStairs(input);

        // then
        assertEquals(result, output);
    }
}
