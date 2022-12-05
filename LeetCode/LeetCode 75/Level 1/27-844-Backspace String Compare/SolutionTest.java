import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Backspace String Compare 예제 1번 테스트")
    void backspaceCompare_example_1_test() {
        // given
        String inputS = "ab#c";
        String inputT = "ad#c";
        boolean output = true;

        // when
        boolean result = SOLUTION.backspaceCompare(inputS, inputT);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Backspace String Compare 예제 2번 테스트")
    void backspaceCompare_example_2_test() {
        // given
        String inputS = "ab##";
        String inputT = "c#d#";
        boolean output = true;

        // when
        boolean result = SOLUTION.backspaceCompare(inputS, inputT);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Backspace String Compare 예제 3번 테스트")
    void backspaceCompare_example_3_test() {
        // given
        String inputS = "a#c";
        String inputT = "b";
        boolean output = false;

        // when
        boolean result = SOLUTION.backspaceCompare(inputS, inputT);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Backspace String Compare 추가 1번 테스트")
    void backspaceCompare_add_1_test() {
        // given
        String inputS = "a##c";
        String inputT = "#a#c";
        boolean output = true;

        // when
        boolean result = SOLUTION.backspaceCompare(inputS, inputT);

        // then
        assertEquals(output, result);
    }
}
