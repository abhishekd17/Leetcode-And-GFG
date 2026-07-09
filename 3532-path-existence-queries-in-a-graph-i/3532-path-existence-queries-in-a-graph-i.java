class Solution {

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        boolean ans[] = new boolean[queries.length];
        int[] component = new int[n];

        component[0] = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                component[i] = component[i - 1];
            } else {
                component[i] = component[i - 1] + 1;
            }
        }
        int i = 0;
        for (int[] q : queries) {
            int u = q[0];
            int v = q[1];
            ans[i++] = component[u] == component[v];
        }
        return ans;
    }
}
