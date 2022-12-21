import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Longest Common Prefix 예제 1번 테스트")
    void longestCommonPrefix_example_1_test() {
        // given
        String[] input = {"flower", "flow", "flight"};
        String output = "fl";

        // when
        String result = SOLUTION.longestCommonPrefix(input);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Longest Common Prefix 예제 2번 테스트")
    void longestCommonPrefix_example_2_test() {
        // given
        String[] input = {"dog", "racecar", "car"};
        String output = "";

        // when
        String result = SOLUTION.longestCommonPrefix(input);

        // then
        assertEquals(output, result);
    }
}
