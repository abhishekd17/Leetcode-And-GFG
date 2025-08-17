class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        
        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                int not_pick = dp[i - 1][j];  // don't use coin i-1
                int pick = 0;
                if (coins[i - 1] <= j) {
                    pick = dp[i][j - coins[i - 1]]; // use same coin again
                }
                dp[i][j] = pick + not_pick;
            }
        }

        return dp[n][amount];
    }
}
