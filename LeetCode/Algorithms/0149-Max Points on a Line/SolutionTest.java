import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Max Points on a Line 예제 1번 테스트")
    void maxPoints_example_1_test() {
        // given
        int[][] input = {{1, 1}, {2, 2}, {3, 3}};
        int output = 3;

        // when
        int result = SOLUTION.maxPoints(input);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Max Points on a Line 예제 2번 테스트")
    void maxPoints_example_2_test() {
        // given
        int[][] input = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        int output = 4;

        // when
        int result = SOLUTION.maxPoints(input);

        // then
        assertEquals(output, result);
    }
}
