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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<Double> list = new ArrayList<>();
        while(!q.isEmpty()){
            int size = q.size();
            Double avg = 0.0;
            for(int i = 0 ; i < size ; i++){
                TreeNode node = q.poll();
                avg += node.val;
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right); 
            }
            avg = avg / size;
            list.add(avg);
        }
        return list;
    }
}