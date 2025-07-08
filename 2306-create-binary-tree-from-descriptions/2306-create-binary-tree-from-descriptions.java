class Solution {
    public TreeNode createBinaryTree(int[][] nums) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> childSet = new HashSet<>();

        for (int[] arr : nums) {
            int parentVal = arr[0];
            int childVal = arr[1];
            int isLeft = arr[2];

            // reuse or create parent
            TreeNode parent = map.getOrDefault(parentVal, new TreeNode(parentVal));
            map.put(parentVal, parent);

            // reuse or create child
            TreeNode child = map.getOrDefault(childVal, new TreeNode(childVal));
            map.put(childVal, child);

            // assign child
            if (isLeft == 1) parent.left = child;
            else parent.right = child;

            childSet.add(childVal);
        }

        // root = node that's never a child
        for (int val : map.keySet()) {
            if (!childSet.contains(val)) {
                return map.get(val);
            }
        }

        return null; // shouldn't happen
    }
}
