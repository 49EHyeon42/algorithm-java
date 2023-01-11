import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Minimum Time to Collect All Apples in a Tree 예제 1번 테스트")
    void minTime_example_1_test() {
        // given
        int inputN = 7;
        int[][] inputEdges = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        List<Boolean> inputHasApple = List.of(false, false, true, false, true, true, false);
        int output = 8;

        // when
        int result = SOLUTION.minTime(inputN, inputEdges, inputHasApple);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Minimum Time to Collect All Apples in a Tree 예제 2번 테스트")
    void minTime_example_2_test() {
        // given
        int inputN = 7;
        int[][] inputEdges = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        List<Boolean> inputHasApple = List.of(false, false, true, false, false, true, false);
        int output = 6;

        // when
        int result = SOLUTION.minTime(inputN, inputEdges, inputHasApple);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Minimum Time to Collect All Apples in a Tree 예제 3번 테스트")
    void minTime_example_3_test() {
        // given
        int inputN = 7;
        int[][] inputEdges = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        List<Boolean> inputHasApple = List.of(false, false, false, false, false, false, false);
        int output = 0;

        // when
        int result = SOLUTION.minTime(inputN, inputEdges, inputHasApple);

        // then
        assertEquals(output, result);
    }
}
