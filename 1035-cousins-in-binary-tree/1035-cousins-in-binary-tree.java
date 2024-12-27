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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        boolean flag1 = false , flag2 = false;
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode node = q.poll();
                if (node.left != null && node.right != null) {
                    if ((node.left.val == x && node.right.val == y) ||
                        (node.left.val == y && node.right.val == x)) {
                        return false; 
                    }
                }
                
                if(node.val == x) flag1 = true;
                if(node.val == y) flag2 = true;
                if(flag1 == true && flag2 == true) return true;
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            flag1 = false;
            flag2 =false;
        }
        return false;
    }
}