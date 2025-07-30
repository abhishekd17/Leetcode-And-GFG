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
    int ans = 0;
    public int averageOfSubtree(TreeNode root) {
        if(root == null) return 0;
        helper(root);
        return ans;
    }

    private int[] helper(TreeNode root){
        if(root == null) return new int[]{0 , 0};
        // traverse in left
        int x[] = helper(root.left);
        // traverse in right
        int y[] = helper(root.right);
        // now do main work
        int sum = x[0] + y[0] + root.val;
        int cnt = x[1] + y[1] + 1;

        int z = sum / cnt;
        if(z == root.val){
            ans++;
        }
        return new int[]{sum , cnt};
    }
}