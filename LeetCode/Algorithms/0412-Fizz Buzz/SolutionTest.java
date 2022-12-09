import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Fizz Buzz 예제 1번 테스트")
    void fizzBuzz_example_1_test() {
        // given
        int input = 3;
        List<String> output = new ArrayList<>(List.of("1", "2", "Fizz"));

        // when
        List<String> result = SOLUTION.fizzBuzz(input);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Fizz Buzz 예제 2번 테스트")
    void fizzBuzz_example_2_test() {
        // given
        int input = 5;
        List<String> output = new ArrayList<>(List.of("1", "2", "Fizz", "4", "Buzz"));

        // when
        List<String> result = SOLUTION.fizzBuzz(input);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Fizz Buzz 예제 3번 테스트")
    void fizzBuzz_example_3_test() {
        // given
        int input = 15;
        List<String> output = new ArrayList<>(
            List.of("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz",
                "13", "14", "FizzBuzz"));

        // when
        List<String> result = SOLUTION.fizzBuzz(input);

        // then
        assertEquals(output, result);
    }
}
