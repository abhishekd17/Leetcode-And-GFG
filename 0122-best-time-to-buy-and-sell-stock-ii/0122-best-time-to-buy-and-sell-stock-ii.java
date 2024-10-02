class Solution {
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
}