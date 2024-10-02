class Solution {
    public int maxProfit(int[] prices, int fee) {
        int dp[][]= new int[prices.length][2];
        for(int[] a : dp){
            Arrays.fill(a , -1);
        }
        return helper(prices , 0 , 1 , fee , dp);
    }
    private int helper(int[] price , int ind , int buy , int fee , int dp[][]){
        if(ind == price.length) return 0;
        if(dp[ind][buy]!=-1) return dp[ind][buy];
        int profit = 0;
        if(buy == 1){
            dp[ind][buy] = Math.max(-price[ind] + helper(price , ind + 1  , 0 , fee , dp ) , helper(price , ind + 1 , 1 , fee ,dp));
        }else{
            dp[ind][buy] = Math.max(price[ind] - fee + helper(price , ind + 1 , 1 , fee , dp) , helper(price , ind + 1 , 0 , fee , dp));
        }
        return dp[ind][buy];
    }
}