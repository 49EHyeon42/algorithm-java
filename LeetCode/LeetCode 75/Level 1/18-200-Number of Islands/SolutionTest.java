import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Number of Islands 예제 1번 테스트")
    void numIslands_example_1_test() {
        // given
        char[][] input = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        int output = 1;

        // when
        int result = SOLUTION.numIslands(input);

        // then
        assertEquals(result, output);
    }

    @Test
    @DisplayName("Number of Islands 예제 2번 테스트")
    void numIslands_example_2_test() {
        // given
        char[][] input = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        int output = 3;

        // when
        int result = SOLUTION.numIslands(input);

        // then
        assertEquals(result, output);
    }
}
