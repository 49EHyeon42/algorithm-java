import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Add Binary 예제 1번 테스트")
    void addBinary_example_1_test() {
        // given
        String inputA = "11";
        String inputB = "1";
        String output = "100";

        // when
        String result = SOLUTION.addBinary(inputA, inputB);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Add Binary 예제 2번 테스트")
    void addBinary_example_2_test() {
        // given
        String inputA = "1010";
        String inputB = "1011";
        String output = "10101";

        // when
        String result = SOLUTION.addBinary(inputA, inputB);

        // then
        assertEquals(output, result);
    }
}
