import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// official solution : https://leetcode.com/problems/binary-tree-preorder-traversal/solutions/2918429/binary-tree-preorder-traversal/
public class Solution {

    // Approach 1 : Recursion
    // Time complexity : O(N)
    // Space complexity : O(N)
    private final List<Integer> list = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        dfs(root);
        return list;
    }

    private void dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        list.add(treeNode.val);
        dfs(treeNode.left);
        dfs(treeNode.right);
    }

    // Approach 2 : Iteration
    // Time complexity : O(N)
    // Space complexity : O(N)
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode currentTreeNode = stack.pop();

            if (currentTreeNode != null) {
                list.add(currentTreeNode.val);
                stack.add(currentTreeNode.right);
                stack.add(currentTreeNode.left);
            }
        }

        return list;
    }

    // Approach 3 : Morris Traversal
    // Time complexity : O(N)
    // Space complexity : O(1)
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode currentTreeNode = root;
        TreeNode lastNode;

        while (currentTreeNode != null) {
            if (currentTreeNode.left == null) {
                list.add(currentTreeNode.val);
                currentTreeNode = currentTreeNode.right;
            } else {
                lastNode = currentTreeNode.left;
                while (lastNode.right != null && lastNode.right != currentTreeNode) {
                    lastNode = lastNode.right;
                }

                if (lastNode.right == null) {
                    list.add(currentTreeNode.val);
                    lastNode.right = currentTreeNode;
                    currentTreeNode = currentTreeNode.left;
                } else {
                    lastNode.right = null;
                    currentTreeNode = currentTreeNode.right;
                }
            }
        }

        return list;
    }
}
