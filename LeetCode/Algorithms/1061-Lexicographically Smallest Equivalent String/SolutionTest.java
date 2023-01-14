import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Lexicographically Smallest Equivalent String 예제 1번 테스트")
    void smallestEquivalentString_example_1_test() {
        // given
        String inputS1 = "parker";
        String inputS2 = "morris";
        String inputBaseStr = "parser";
        String output = "makkek";

        // when
        String result = SOLUTION.smallestEquivalentString(inputS1, inputS2, inputBaseStr);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Lexicographically Smallest Equivalent String 예제 2번 테스트")
    void smallestEquivalentString_example_2_test() {
        // given
        String inputS1 = "hello";
        String inputS2 = "world";
        String inputBaseStr = "hold";
        String output = "hdld";

        // when
        String result = SOLUTION.smallestEquivalentString(inputS1, inputS2, inputBaseStr);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Lexicographically Smallest Equivalent String 예제 3번 테스트")
    void smallestEquivalentString_example_3_test() {
        // given
        String inputS1 = "leetcode";
        String inputS2 = "programs";
        String inputBaseStr = "sourcecode";
        String output = "aauaaaaada";

        // when
        String result = SOLUTION.smallestEquivalentString(inputS1, inputS2, inputBaseStr);

        // then
        assertEquals(output, result);
    }
}
