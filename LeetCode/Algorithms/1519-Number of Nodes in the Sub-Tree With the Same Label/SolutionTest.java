import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Number of Nodes in the Sub-Tree With the Same Label 예제 1번 테스트")
    void countSubTrees_example_1_test() {
        // given
        int inputN = 7;
        int[][] inputEdges = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        String inputLabels = "abaedcd";
        int[] output = {2, 1, 1, 1, 1, 1, 1};

        // when
        int[] result = SOLUTION.countSubTrees(inputN, inputEdges, inputLabels);

        // then
        assertArrayEquals(output, result);
    }

    @Test
    @DisplayName("Number of Nodes in the Sub-Tree With the Same Label 예제 2번 테스트")
    void countSubTrees_example_2_test() {
        // given
        int inputN = 4;
        int[][] inputEdges = {{0, 1}, {1, 2}, {0, 3}};
        String inputLabels = "bbbb";
        int[] output = {4, 2, 1, 1};

        // when
        int[] result = SOLUTION.countSubTrees(inputN, inputEdges, inputLabels);

        // then
        assertArrayEquals(output, result);
    }

    @Test
    @DisplayName("Number of Nodes in the Sub-Tree With the Same Label 예제 3번 테스트")
    void countSubTrees_example_3_test() {
        // given
        int inputN = 5;
        int[][] inputEdges = {{0, 1}, {0, 2}, {1, 3}, {0, 4}};
        String inputLabels = "aabab";
        int[] output = {3, 2, 1, 1, 1};

        // when
        int[] result = SOLUTION.countSubTrees(inputN, inputEdges, inputLabels);

        // then
        assertArrayEquals(output, result);
    }
}
