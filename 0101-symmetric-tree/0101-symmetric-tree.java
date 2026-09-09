class Solution {

    private boolean isSymmetricUtil(TreeNode root1, TreeNode root2) {

        // Both nodes are null
        if (root1 == null && root2 == null) {
            return true;
        }

        // One node is null and the other is not
        if (root1 == null || root2 == null) {
            return false;
        }

        // Values must be equal and subtrees must be mirror images
        return (root1.val == root2.val)
                && isSymmetricUtil(root1.left, root2.right)
                && isSymmetricUtil(root1.right, root2.left);
    }

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        return isSymmetricUtil(root.left, root.right);
    }
}