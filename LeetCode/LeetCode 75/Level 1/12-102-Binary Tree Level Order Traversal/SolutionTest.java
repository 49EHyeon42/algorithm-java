import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    @DisplayName("Binary Tree Level Order Traversal 예제 1번 테스트")
    void levelOrder_example_1_test() {
        Solution solution = new Solution();

        // given
        TreeNode input = new TreeNode(3);
        input.left = new TreeNode(9);
        input.right = new TreeNode(20);
        input.right.left = new TreeNode(15);
        input.right.right = new TreeNode(7);
        List<List<Integer>> output = List.of(List.of(3), List.of(9, 20), List.of(15, 7));

        // when
        List<List<Integer>> result = solution.levelOrder(input);

        // then
        assertEquals(result, output);
    }

    @Test
    @DisplayName("Binary Tree Level Order Traversal 예제 2번 테스트")
    void levelOrder_example_2_test() {
        Solution solution = new Solution();

        // given
        TreeNode input = new TreeNode(1);
        List<List<Integer>> output = List.of(List.of(1));

        // when
        List<List<Integer>> result = solution.levelOrder(input);

        // then
        assertEquals(result, output);
    }

    @Test
    @DisplayName("Binary Tree Level Order Traversal 예제 3번 테스트")
    void levelOrder_example_3_test() {
        Solution solution = new Solution();

        // given
        TreeNode input = null;
        List<List<Integer>> output = List.of();

        // when
        List<List<Integer>> result = solution.levelOrder(input);

        // then
        assertEquals(result, output);
    }
}
