import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Contains Duplicate II 예제 1번 테스트")
    void containsNearbyDuplicate_example_1_test() {
        // given
        int[] inputNums = {1, 2, 3, 1};
        int inputK = 3;
        boolean output = true;

        // when
        boolean result = SOLUTION.containsNearbyDuplicate(inputNums, inputK);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Contains Duplicate II 예제 2번 테스트")
    void containsNearbyDuplicate_example_2_test() {
        // given
        int[] inputNums = {1, 0, 1, 1};
        int inputK = 1;
        boolean output = true;

        // when
        boolean result = SOLUTION.containsNearbyDuplicate(inputNums, inputK);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Contains Duplicate II 예제 3번 테스트")
    void containsNearbyDuplicate_example_3_test() {
        // given
        int[] inputNums = {1, 2, 3, 1, 2, 3};
        int inputK = 2;
        boolean output = false;

        // when
        boolean result = SOLUTION.containsNearbyDuplicate(inputNums, inputK);

        // then
        assertEquals(output, result);
    }
}
