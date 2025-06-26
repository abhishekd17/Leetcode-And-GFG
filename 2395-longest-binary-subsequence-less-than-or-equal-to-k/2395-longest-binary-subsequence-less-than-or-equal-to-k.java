class Solution {
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n][n + 1]; 
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(n - 1, 0, k, s, dp);
    }

    private int helper(int ind, int size, int sum, String s, int[][] dp) {
        if (ind < 0) return 0;
        if (dp[ind][size] != -1) return dp[ind][size];

        int np = helper(ind - 1, size, sum, s, dp);

        int p = 0;
        int bit = s.charAt(ind) - '0';

        if (bit == 0 || (size < 31 && (bit << size) <= sum)) {
            int val = bit << size;
            p = 1 + helper(ind - 1, size + 1, sum - val, s, dp);
        }

        return dp[ind][size] = Math.max(p, np);
    }
}
