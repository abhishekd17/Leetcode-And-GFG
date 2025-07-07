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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root , 0));
        int maxi = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int start = 0 ,  end = 0;
            for(int i = 0 ; i < size ; i++){
                Pair pair = q.poll();
                TreeNode node = pair.node;
                int idx = pair.idx;
                if(i == 0) start = idx;
                if(i == size - 1) end = idx;
                if(node.left != null) q.offer(new Pair(node.left , 2 * idx + 1));
                if(node.right != null) q.offer(new Pair(node.right , 2 * idx + 2));
            }
            maxi = Math.max(maxi , end - start + 1);
        }
        return maxi;
    }
}

class Pair{
    TreeNode node;
    int idx;
    Pair(TreeNode node , int idx){
        this.node = node;
        this.idx = idx;
    }
}