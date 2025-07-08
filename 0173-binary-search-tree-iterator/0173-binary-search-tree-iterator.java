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
class BSTIterator {
    List<Integer> list;
    int ind ;
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        helper(root , list);
        ind = 0;
    }
    
    public int next() {
        return list.get(ind++);
    }
    
    public boolean hasNext() {
        return ind < list.size();
    }

    private void helper(TreeNode root , List<Integer> list){
        if(root == null) return;
        helper(root.left , list);
        list.add(root.val);
        helper(root.right , list);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */