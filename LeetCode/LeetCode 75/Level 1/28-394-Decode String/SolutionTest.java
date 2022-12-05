import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Decode String 예제 1번 테스트")
    void decodeString_example_1_test() {
        // given
        String input = "3[a]2[bc]";
        String output = "aaabcbc";

        // when
        String result = SOLUTION.decodeString(input);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Decode String 예제 2번 테스트")
    void decodeString_example_2_test() {
        // given
        String input = "3[a2[c]]";
        String output = "accaccacc";

        // when
        String result = SOLUTION.decodeString(input);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Decode String 예제 3번 테스트")
    void decodeString_example_3_test() {
        // given
        String input = "2[abc]3[cd]ef";
        String output = "abcabccdcdcdef";

        // when
        String result = SOLUTION.decodeString(input);

        // then
        assertEquals(output, result);
    }
}
