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
class Solution {
    // Global variable to store max path sum
    int maxSum = Integer.MIN_VALUE;

    // Main function
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    // DFS recursive function
    private int dfs(TreeNode node) {
        if (node == null) return 0;

        // Calculate left and right subtree max path
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        // Update max sum considering current node
        maxSum = Math.max(
            maxSum,
            left + right + node.val
        );

        // Return one-sided path
        return Math.max(left, right) + node.val;
    }
}
