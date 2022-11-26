import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    @DisplayName("Is Subsequence 예제 1번 테스트")
    void isSubsequence_example_1_test() {
        Solution solution = new Solution();

        // given
        String inputS = "abc";
        String inputT = "ahbgdc";
        boolean output = true;

        // when
        boolean result = solution.isSubsequence(inputS, inputT);

        // then
        assertEquals(result, output);
    }

    @Test
    @DisplayName("Is Subsequence 예제 2번 테스트")
    void isSubsequence_example_2_test() {
        Solution solution = new Solution();

        // given
        String inputS = "axc";
        String inputT = "ahbgdc";
        boolean output = false;

        // when
        boolean result = solution.isSubsequence(inputS, inputT);

        // then
        assertEquals(result, output);
    }
}
