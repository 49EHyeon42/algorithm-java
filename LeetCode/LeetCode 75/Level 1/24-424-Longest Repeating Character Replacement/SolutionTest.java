import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Longest Repeating Character Replacement 예제 1번 테스트")
    void characterReplacement_example_1_test() {
        // given
        String inputS = "ABAB";
        int inputK = 2;
        int output = 4;

        // when
        int result = SOLUTION.characterReplacement(inputS, inputK);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Longest Repeating Character Replacement 예제 2번 테스트")
    void characterReplacement_example_2_test() {
        // given
        String inputS = "AABABBA";
        int inputK = 1;
        int output = 4;

        // when
        int result = SOLUTION.characterReplacement(inputS, inputK);

        // then
        assertEquals(output, result);
    }
}
