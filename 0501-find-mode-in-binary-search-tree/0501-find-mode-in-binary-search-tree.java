class Solution {
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
