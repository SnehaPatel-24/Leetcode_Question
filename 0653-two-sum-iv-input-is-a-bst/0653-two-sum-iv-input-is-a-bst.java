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
class TreeNode {
    // This stores the value of the node
    int val;
    // Pointer to the left child node
    TreeNode left;
    // Pointer to the right child node
    TreeNode right;

    // Constructor initializes the node with a given value
    // and sets left and right pointers to null
    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

// This class is an iterator that allows us to traverse the BST
class BSTIterator {
    // Stack is used to keep track of nodes while traversing
    private java.util.Stack<TreeNode> stack;
    // This flag tells us whether we move forward (inorder) or backward (reverse inorder)
    private boolean reverse;

    // Constructor initializes the iterator with root and traversal mode
    BSTIterator(TreeNode root, boolean isReverse) {
        stack = new java.util.Stack<>();
        reverse = isReverse;
        // Push nodes from one side into the stack
        pushAll(root);
    }

    // This function checks if there are still nodes to visit
    boolean hasNext() {
        // If stack is not empty, then we still have nodes left
        return !stack.isEmpty();
    }

    // This function returns the next node’s value in the chosen order
    int next() {
        // Get the node on top of the stack
        TreeNode tmpNode = stack.pop();

        // If we are not in reverse mode, move to the right child
        if (!reverse) {
            pushAll(tmpNode.right);
        }
        // If we are in reverse mode, move to the left child
        else {
            pushAll(tmpNode.left);
        }

        // Return the value of the node we just processed
        return tmpNode.val;
    }

    // Helper function pushes nodes from current down to edge (left or right)
    private void pushAll(TreeNode node) {
        // Keep going until node becomes null
        while (node != null) {
            // Push this node into stack
            stack.push(node);
            // If reverse is true, move to right child
            if (reverse) {
                node = node.right;
            }
            // Otherwise, move to left child
            else {
                node = node.left;
            }
        }
    }
}

// This class contains the solution logic
class Solution {
    // Function checks if BST has two elements that sum to target k
    public boolean findTarget(TreeNode root, int k) {
        // If root is null, tree is empty, return false
        if (root == null) return false;

        // Create two iterators: one from smallest, one from largest
        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);

        // Get the first values
        int i = l.next();
        int j = r.next();

        // Loop until two values meet
        while (i < j) {
            // If sum is exactly k, return true
            if (i + j == k) return true;
            // If sum is smaller, move left iterator forward
            else if (i + j < k) i = l.next();
            // If sum is bigger, move right iterator backward
            else j = r.next();
        }

        // If no such pair found, return false
        return false;
    }
}