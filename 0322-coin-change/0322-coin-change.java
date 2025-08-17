class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int INF = (int)1e9;  // A large value like Integer.MAX_VALUE-1 to avoid overflow
        
        int[][] dp = new int[n + 1][amount + 1];

        // Base Case: if amount == 0 → 0 coins needed
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        // If no coins available (i=0) but amount > 0 → INF (impossible)
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = INF;
        }

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                int not_pick = dp[i - 1][j];  // don't use coin i-1
                int pick = INF;
                if (coins[i - 1] <= j) {
                    pick = 1 + dp[i][j - coins[i - 1]]; // use same coin again
                }
                dp[i][j] = Math.min(pick, not_pick);
            }
        }

        return dp[n][amount] >= INF ? -1 : dp[n][amount];
    }
}
