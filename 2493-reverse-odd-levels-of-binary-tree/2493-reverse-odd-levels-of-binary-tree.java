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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            List<TreeNode> list = new ArrayList<>();

            for(int i = 0 ; i < size ; i++){
                TreeNode node = q.poll();
                list.add(node);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }

            if(level % 2 == 1){
                int l = 0;
                int r = list.size() - 1;
                while(l < r ){
                    int temp = list.get(l).val;
                    list.get(l).val = list.get(r).val;
                    list.get(r).val = temp;
                    l++;
                    r--;
                }
            }
            level++;
        }
        return root;
    }
}