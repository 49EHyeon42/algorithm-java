import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Contains Duplicate 예제 1번 테스트")
    void containsDuplicate_example_1_test() {
        // given
        int[] input = {1, 2, 3, 1};
        boolean output = true;

        // when
        boolean result = SOLUTION.containsDuplicate(input);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Contains Duplicate 예제 2번 테스트")
    void containsDuplicate_example_2_test() {
        // given
        int[] input = {1, 2, 3, 4};
        boolean output = false;

        // when
        boolean result = SOLUTION.containsDuplicate(input);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Contains Duplicate 예제 3번 테스트")
    void containsDuplicate_example_3_test() {
        // given
        int[] input = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        boolean output = true;

        // when
        boolean result = SOLUTION.containsDuplicate(input);

        // then
        assertEquals(output, result);
    }
}
