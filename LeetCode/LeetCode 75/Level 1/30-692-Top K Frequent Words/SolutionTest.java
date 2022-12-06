import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Top K Frequent Words 예제 1번 테스트")
    void topKFrequent_example_1_test() {
        // given
        String[] inputWords = {"i", "love", "leetcode", "i", "love", "coding"};
        int inputK = 2;
        List<String> output = List.of("i", "love");

        // when
        List<String> result = SOLUTION.topKFrequent(inputWords, inputK);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Top K Frequent Words 예제 2번 테스트")
    void topKFrequent_example_2_test() {
        // given
        String[] inputWords = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is",
            "is"};
        int inputK = 4;
        List<String> output = List.of("the", "is", "sunny", "day");

        // when
        List<String> result = SOLUTION.topKFrequent(inputWords, inputK);

        // then
        assertEquals(output, result);
    }
}
