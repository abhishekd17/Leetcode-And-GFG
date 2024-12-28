/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null) return null;
        if(original == target) return cloned;
        TreeNode left = getTargetCopy(original.left , cloned.left , target);
        if(left != null) return left;
        return getTargetCopy(original.right , cloned.right , target);
    }
}

/*class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null) return null;
        Queue<TreeNode[]> q = new LinkedList<>();
        q.offer(new TreeNode[] { original , cloned});
        while(!q.isEmpty()){
            TreeNode nodeOriginal = q.peek()[0];
            TreeNode nodeCloned = q.peek()[1];
            q.poll();
            if(nodeOriginal == target) return nodeCloned;

            if(nodeOriginal.left != null){
                q.offer(new TreeNode[]{nodeOriginal.left , nodeCloned.left});
            }
            if(nodeOriginal.right != null){
                q.offer(new TreeNode[]{nodeOriginal.right , nodeCloned.right});
            }
        }
        return null;
    }
} */