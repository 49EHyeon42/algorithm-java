import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Unique Paths 예제 1번 테스트")
    void uniquePaths_example_1_test() {
        // given
        int inputM = 3;
        int inputN = 7;
        int output = 28;

        // when
        int result = SOLUTION.uniquePaths(inputM, inputN);

        // then
        assertEquals(result, output);
    }

    @Test
    @DisplayName("Unique Paths 예제 2번 테스트")
    void uniquePaths_example_2_test() {
        // given
        int inputM = 3;
        int inputN = 2;
        int output = 3;

        // when
        int result = SOLUTION.uniquePaths(inputM, inputN);

        // then
        assertEquals(result, output);
    }
}
