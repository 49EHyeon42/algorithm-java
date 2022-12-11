import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Palindrome Number 예제 1번 테스트")
    void isPalindrome_example_1_test() {
        // given
        int input = 121;
        boolean output = true;

        // when
        boolean result = SOLUTION.isPalindrome(input);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Palindrome Number 예제 2번 테스트")
    void isPalindrome_example_2_test() {
        // given
        int input = -121;
        boolean output = false;

        // when
        boolean result = SOLUTION.isPalindrome(input);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Palindrome Number 예제 3번 테스트")
    void isPalindrome_example_3_test() {
        // given
        int input = 10;
        boolean output = false;

        // when
        boolean result = SOLUTION.isPalindrome(input);

        // then
        assertEquals(output, result);
    }
}
