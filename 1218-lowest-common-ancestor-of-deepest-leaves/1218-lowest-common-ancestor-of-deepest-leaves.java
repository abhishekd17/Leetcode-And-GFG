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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        
        int maxDepth = getDepth(root);
        int level = 1;

        q.offer(root);

        List<TreeNode> nodes = new ArrayList<>();

        while(!q.isEmpty()){
            int size = q.size();
            if(level == maxDepth){
                nodes.addAll(q);
                break;
            }
            for(int i = 0 ; i < size ; i++){
                TreeNode node = q.poll();
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            level++;
        }

        return findLCA(root , nodes);
    }
    
    private int getDepth(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(getDepth(root.left) , getDepth(root.right));
    }

    private TreeNode findLCA(TreeNode root , List<TreeNode> nodes){
        if(root == null) return null;
        if(nodes.contains(root)) return root;
        TreeNode left = findLCA(root.left , nodes);
        TreeNode right = findLCA(root.right , nodes);
        if(left == null) return right;
        else if(right == null ) return left;
        else return root;
    }
}