
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;

class Solution {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        Queue<TempNode> queue = new LinkedList<>();
        queue.add(new TempNode(root, root.val));

        while (!queue.isEmpty()) {
            TempNode currentTempNode = queue.poll();

            if (currentTempNode.treeNode.left == null && currentTempNode.treeNode.right == null) {
                System.out.println(currentTempNode.sum);

                if (targetSum == currentTempNode.sum) {
                    return true;
                }
            }

            if (currentTempNode.treeNode.left != null) {
                queue.offer(new TempNode(currentTempNode.treeNode.left,
                        currentTempNode.treeNode.left.val + currentTempNode.sum));
            }

            if (currentTempNode.treeNode.right != null) {
                queue.offer(new TempNode(currentTempNode.treeNode.right,
                        currentTempNode.treeNode.right.val + currentTempNode.sum));
            }
        }

        return false;
    }

    private static class TempNode {

        TreeNode treeNode;
        int sum;

        TempNode(TreeNode treeNode, int sum) {
            this.treeNode = treeNode;
            this.sum = sum;
        }
    }
}
