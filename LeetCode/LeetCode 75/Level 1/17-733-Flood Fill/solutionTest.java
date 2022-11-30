import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Flood Fill 예제 1번 테스트")
    void floodFill_example_1_test() {
        // given
        int[][] inputImage = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int inputSr = 1;
        int inputSc = 1;
        int inputColor = 2;
        int[][] output = {{2, 2, 2}, {2, 2, 0}, {2, 0, 1}};

        // when
        int[][] result = SOLUTION.floodFill(inputImage, inputSr, inputSc, inputColor);

        // then
        assertArrayEquals(result, output);
    }

    @Test
    @DisplayName("Flood Fill 예제 2번 테스트")
    void floodFill_example_2_test() {
        // given
        int[][] inputImage = {{0, 0, 0}, {0, 0, 0}};
        int inputSr = 0;
        int inputSc = 0;
        int inputColor = 0;
        int[][] output = {{0, 0, 0}, {0, 0, 0}};

        // when
        int[][] result = SOLUTION.floodFill(inputImage, inputSr, inputSc, inputColor);

        // then
        assertArrayEquals(result, output);
    }

    @Test
    @DisplayName("Flood Fill 예제 추가 1")
    void floodFill_example_add_1() {
        // given
        int[][] inputImage = {{0, 0, 0}, {0, 1, 0}};
        int inputSr = 1;
        int inputSc = 1;
        int inputColor = 2;
        int[][] output = {{0, 0, 0}, {0, 2, 0}};

        // when
        int[][] result = SOLUTION.floodFill(inputImage, inputSr, inputSc, inputColor);

        // then
        assertArrayEquals(result, output);
    }
}
