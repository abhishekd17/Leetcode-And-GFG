class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int prev[] = new int[2];
        
        prev[0] = 0;
        prev[1] = 0;

        int profit = 0;
        for(int i = n - 1 ; i >= 0 ; i--){
            int curr[] = new int[2];
            for(int j = 0 ; j <= 1 ; j++){
                if(j == 0){
                   profit = Math.max(- prices[i] + prev[1] , prev[0]);
                }
                if(j==1){
                    profit = Math.max(prices[i] + prev[0] , prev[1]);
                }
                curr[j] = profit;
            }
            prev = curr;
        }
        return prev[0];
    }
}
/*class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int dp[][] = new int[n + 1][2];
        for(int[] a : dp){
            Arrays.fill(a , -1);
        }
        dp[n][0] = 0;
        dp[n][1] = 0;
        int profit = 0;
        for(int i = n - 1 ; i >= 0 ; i--){
            for(int j = 0 ; j <= 1 ; j++){
                if(j == 0){
                   profit = Math.max(- prices[i] + dp[i + 1][1] , dp[i + 1][0]);
                }
                if(j==1){
                    profit = Math.max(prices[i] + dp[i + 1][0] , dp[i + 1][1]);
                }
                dp[i][j] = profit;
            }
        }
        return dp[0][0];
    }
}*/

/*class Solution {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][2];
        for(int[] a :dp) Arrays.fill(a , -1);
        return helper(prices ,0 , 1 , dp);
    }

    private int helper(int price[] , int ind , int buy , int dp[][]){
        if(ind == price.length) return 0;

        if(dp[ind][buy] != -1) return dp[ind][buy];
        // buy
        int profit = Integer.MIN_VALUE;
        if(buy == 1){
            dp[ind][buy] = Math.max(-price[ind] + helper(price , ind + 1 , 0 , dp)  , helper(price , ind + 1 , 1 , dp));
        }
        // sell
        else{
            dp[ind][buy] = Math.max(price[ind] + helper(price , ind + 1 , 1 , dp) , helper(price , ind + 1 , 0 , dp));
        }
        return dp[ind][buy];
    }
} */