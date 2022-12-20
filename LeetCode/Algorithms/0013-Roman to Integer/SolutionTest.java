import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Roman to Integer 예제 1번 테스트")
    void romanToInt_example_1_test() {
        // given
        String input = "III";
        int output = 3;

        // when
        int result = SOLUTION.romanToInt(input);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Roman to Integer 예제 2번 테스트")
    void romanToInt_example_2_test() {
        // given
        String input = "LVIII";
        int output = 58;

        // when
        int result = SOLUTION.romanToInt(input);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Roman to Integer 예제 3번 테스트")
    void romanToInt_example_3_test() {
        // given
        String input = "MCMXCIV";
        int output = 1994;

        // when
        int result = SOLUTION.romanToInt(input);

        // then
        assertEquals(output, result);
    }
}
