import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    @DisplayName("Validate Binary Search Tree 예제 1번 테스트")
    void isValidBST_example_1_test() {
        Solution solution = new Solution();

        // given
        TreeNode input = new TreeNode(2);
        input.left = new TreeNode(1);
        input.right = new TreeNode(3);
        boolean output = true;

        // when
        boolean result = solution.isValidBST(input);

        // then
        assertEquals(result, output);
    }

    @Test
    @DisplayName("Validate Binary Search Tree 예제 2번 테스트")
    void isValidBST_example_2_test() {
        Solution solution = new Solution();

        // given
        TreeNode input = new TreeNode(5);
        input.left = new TreeNode(1);
        input.right = new TreeNode(4);
        input.right.left = new TreeNode(3);
        input.right.right = new TreeNode(6);
        boolean output = false;

        // when
        boolean result = solution.isValidBST(input);

        // then
        assertEquals(result, output);
    }
}
