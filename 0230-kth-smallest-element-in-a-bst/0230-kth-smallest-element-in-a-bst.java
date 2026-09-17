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
   private int k;
    private int result;

    // Function to find the kth smallest element
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        this.result = -1;
        inorder(root);
        return result;
    }

    // Helper function for inorder traversal
    private void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            if (--k == 0) {
                result = node.val;
                return;
            }
            inorder(node.right);
        }
    }
}

