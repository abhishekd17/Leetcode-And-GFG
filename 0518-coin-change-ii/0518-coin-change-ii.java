// class Solution {
//     public int change(int amount, int[] coins) {
//         int n = coins.length;
        
//         int[][] dp = new int[n + 1][amount + 1];

//         for (int i = 0; i <= n; i++) {
//             dp[i][0] = 1;
//         }

//         for (int i = 1; i <= n; i++) {
//             for (int j = 1; j <= amount; j++) {
//                 int not_pick = dp[i - 1][j];  // don't use coin i-1
//                 int pick = 0;
//                 if (coins[i - 1] <= j) {
//                     pick = dp[i][j - coins[i - 1]]; // use same coin again
//                 }
//                 dp[i][j] = pick + not_pick;
//             }
//         }

//         return dp[n][amount];
//     }
// }


class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return helper(coins, 0, amount, dp);
    }
    
    private int helper(int[] coins, int idx, int amount, int[][] dp) {
        // Base case: amount completed
        if (amount == 0) return 1;
        
        // If no coins left but amount > 0
        if (idx == coins.length) return 0;
        
        if (dp[idx][amount] != -1) return dp[idx][amount];
        
        // Not pick the current coin
        int notPick = helper(coins, idx + 1, amount, dp);
        
        // Pick the current coin (stay at idx because unlimited coins allowed)
        int pick = 0;
        if (coins[idx] <= amount) {
            pick = helper(coins, idx, amount - coins[idx], dp);
        }
        
        return dp[idx][amount] = pick + notPick;
    }
}
