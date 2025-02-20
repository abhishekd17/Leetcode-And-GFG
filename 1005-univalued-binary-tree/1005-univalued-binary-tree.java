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
    public boolean isUnivalTree(TreeNode root) {
        return (root.left == null || root.left.val == root.val && isUnivalTree(root.left)) &&
        (root.right == null || root.right.val == root.val && isUnivalTree(root.right));
    }
}

/*class Solution {
    int val = -1;
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;
        if(val < 0) val = root.val;
        return root.val == val && isUnivalTree(root.left) && isUnivalTree(root.right);
    }
} */