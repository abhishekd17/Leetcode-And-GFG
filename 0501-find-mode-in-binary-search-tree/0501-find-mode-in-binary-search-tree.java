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
    private int currVal ;
    private int currCount = 0;
    private int maxCount = 0;
    private int modeCount = 0;
    private int[] modes;

    public int[] findMode(TreeNode root) {
        inorder(root);
        modes = new int[modeCount];
        modeCount = 0;
        currCount = 0;
        inorder(root);
        return modes;

    }

    private void handleValue(int val){
        if(val != currVal){
            currVal = val;
            currCount = 0;
        }
        currCount++;
        if(currCount > maxCount){
            maxCount = currCount;
            modeCount = 1;
        }else if(currCount == maxCount){
            if(modes != null){
                modes[modeCount] = currVal;
            }
            modeCount++;
        }
    }

    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        handleValue(root.val);
        inorder(root.right);
    }
}


/*class Solution {
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[]{};

        // Step 1: Collect frequencies using a shared map
        HashMap<Integer, Integer> map = new HashMap<>();
        traverseAndCount(root, map);

        // Step 2: Find the maximum frequency
        int maxFreq = 0;
        for (int freq : map.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }

        // Step 3: Collect all elements with the maximum frequency
        List<Integer> modes = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == maxFreq) {
                modes.add(key);
            }
        }

        // Step 4: Convert the list to an array
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

    private void traverseAndCount(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) return;
        traverseAndCount(root.left, map);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        traverseAndCount(root.right, map);
    }
}
 */