import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Bulls and Cows 예제 1번 테스트")
    void getHint_example_1_test() {
        // given
        String inputSecret = "1807";
        String inputGuess = "7810";
        String output = "1A3B";

        // when
        String result = SOLUTION.getHint(inputSecret, inputGuess);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Bulls and Cows 예제 2번 테스트")
    void getHint_example_2_test() {
        // given
        String inputSecret = "1123";
        String inputGuess = "0111";
        String output = "1A1B";

        // when
        String result = SOLUTION.getHint(inputSecret, inputGuess);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Bulls and Cows 추가 1번 테스트")
    void getHint_add_1_test() {
        // given
        String inputSecret = "1122";
        String inputGuess = "2211";
        String output = "0A4B";

        // when
        String result = SOLUTION.getHint(inputSecret, inputGuess);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Bulls and Cows 추가 2번 테스트")
    void getHint_add_2_test() {
        // given
        String inputSecret = "1122";
        String inputGuess = "1222";
        String output = "3A0B";

        // when
        String result = SOLUTION.getHint(inputSecret, inputGuess);

        // then
        assertEquals(output, result);
    }
}
