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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans  = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(root , targetSum , ans ,list);
        return ans;
    }

    private void helper(TreeNode node , int targetSum , List<List<Integer>> ans , List<Integer> list){
        if(node == null) return ;

        list.add(node.val);
        targetSum -= node.val;

        if(node.left == null && node.right == null && targetSum==0){
            ans.add(new ArrayList<>(list));
        }else{
            helper(node.left , targetSum , ans , list);
            helper(node.right , targetSum , ans , list);
        }

        list.remove(list.size() - 1);
    }
}