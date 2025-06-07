class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        int ans = helper(coins, 0, amount, dp);
        return (ans == Integer.MAX_VALUE - 1) ? -1 : ans;
    }

    private int helper(int[] coins, int idx, int amount, int[][] dp) {
        if (amount == 0) return 0;
        if (idx >= coins.length) return Integer.MAX_VALUE - 1;

        if (dp[idx][amount] != -1) return dp[idx][amount];

        int not_pick = helper(coins, idx + 1, amount, dp);
        int pick = Integer.MAX_VALUE - 1;

        if (amount >= coins[idx]) {
            pick = 1 + helper(coins, idx, amount - coins[idx], dp);
        }

        dp[idx][amount] = Math.min(pick, not_pick);
        return dp[idx][amount];
    }
}
