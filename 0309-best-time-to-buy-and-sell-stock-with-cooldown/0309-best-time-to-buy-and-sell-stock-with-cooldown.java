class Solution {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][2];
        for(int[] a:dp){
            Arrays.fill(a , -1);
        }
        return helper(prices , 0 , 1, dp);
    }
    private int helper(int[] price , int ind , int buy , int[][] dp ){
        // base 
        if(ind >= price.length) return 0;
        if(dp[ind][buy] != -1) return dp[ind][buy];
        int profit = 0;
        if(buy == 1 ){
            dp[ind][buy] = Math.max(helper(price , ind + 1 , 0 ,dp ) - price[ind] , helper(price , ind + 1 , 1 ,dp));
        }else if(buy == 0  && ind < price.length ){
            dp[ind][buy] = Math.max(helper(price , ind + 2 , 1 ,dp) + price[ind] , helper(price , ind + 1 , 0 , dp));
        }
        return dp[ind][buy];
    }
}