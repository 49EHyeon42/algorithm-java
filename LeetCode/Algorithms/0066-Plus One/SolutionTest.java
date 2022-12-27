import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Plus One 예제 1번 테스트")
    void plusOne_example_1_test() {
        // given
        int[] input = {1, 2, 3};
        int[] output = {1, 2, 4};

        // when
        int[] result = SOLUTION.plusOne(input);

        // then
        assertArrayEquals(output, result);
    }

    @Test
    @DisplayName("Plus One 예제 2번 테스트")
    void plusOne_example_2_test() {
        // given
        int[] input = {4, 3, 2, 1};
        int[] output = {4, 3, 2, 2};

        // when
        int[] result = SOLUTION.plusOne(input);

        // then
        assertArrayEquals(output, result);
    }

    @Test
    @DisplayName("Plus One 예제 3번 테스트")
    void plusOne_example_3_test() {
        // given
        int[] input = {9};
        int[] output = {1, 0};

        // when
        int[] result = SOLUTION.plusOne(input);

        // then
        assertArrayEquals(output, result);
    }

    @Test
    @DisplayName("Plus One 추가 1번 테스트 - int 범위 초과")
    void plusOne_add_1_test() {
        // given
        int[] input = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] output = {9, 8, 7, 6, 5, 4, 3, 2, 1, 1};

        // when
        int[] result = SOLUTION.plusOne(input);

        // then
        assertArrayEquals(output, result);
    }

    @Test
    @DisplayName("Plus One 추가 2번 테스트 - long 범위 초과")
    void plusOne_add_2_test() {
        // given
        int[] input = {6, 1, 4, 5, 3, 9, 0, 1, 9, 5, 1, 8, 6, 7, 0, 5, 5, 4, 3};
        int[] output = {6, 1, 4, 5, 3, 9, 0, 1, 9, 5, 1, 8, 6, 7, 0, 5, 5, 4, 4};

        // when
        int[] result = SOLUTION.plusOne(input);

        // then
        assertArrayEquals(output, result);
    }
}
