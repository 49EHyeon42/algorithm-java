import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    @DisplayName("Longest Palindrome 예제 1번 테스트")
    void longestPalindrome_example_1_test() {
        Solution solution = new Solution();

        // given
        String input = "abccccdd";
        int output = 7;

        // when
        int result = solution.longestPalindrome(input);

        // then
        assertEquals(result, output);
    }

    @Test
    @DisplayName("Longest Palindrome 예제 2번 테스트")
    void longestPalindrome_example_2_test() {
        Solution solution = new Solution();

        // given
        String input = "a";
        int output = 1;

        // when
        int result = solution.longestPalindrome(input);

        // then
        assertEquals(result, output);
    }
}
