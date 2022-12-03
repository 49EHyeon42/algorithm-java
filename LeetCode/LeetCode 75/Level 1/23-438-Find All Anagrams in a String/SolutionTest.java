import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Find All Anagrams in a String 예제 1번 테스트")
    void findAnagrams_example_1_test() {
        // given
        String inputS = "cbaebabacd";
        String inputP = "abc";
        List<Integer> output = List.of(0, 6);

        // when
        List<Integer> result = SOLUTION.findAnagrams(inputS, inputP);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Find All Anagrams in a String 예제 2번 테스트")
    void findAnagrams_example_2_test() {
        // given
        String inputS = "abab";
        String inputP = "ab";
        List<Integer> output = List.of(0, 1, 2);

        // when
        List<Integer> result = SOLUTION.findAnagrams(inputS, inputP);

        // then
        assertEquals(result, output);
    }
}
