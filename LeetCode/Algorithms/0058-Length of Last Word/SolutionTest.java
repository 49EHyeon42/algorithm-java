import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Length of Last Word 예제 1번 테스트")
    void lengthOfLastWord_example_1_test() {
        // given
        String input = "Hello World";
        int output = 5;

        // when
        int result = SOLUTION.lengthOfLastWord(input);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Length of Last Word 예제 2번 테스트")
    void lengthOfLastWord_example_2_test() {
        // given
        String input = "   fly me   to   the moon  ";
        int output = 4;

        // when
        int result = SOLUTION.lengthOfLastWord(input);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Length of Last Word 예제 3번 테스트")
    void lengthOfLastWord_example_3_test() {
        // given
        String input = "luffy is still joyboy";
        int output = 6;

        // when
        int result = SOLUTION.lengthOfLastWord(input);

        // then
        assertEquals(output, result);
    }
}
