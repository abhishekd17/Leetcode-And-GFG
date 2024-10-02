class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n + 2][2];

        for(int i = n-1 ; i >= 0 ; i-- ){
            for(int j = 0 ; j <= 1 ; j++){
                if(j==0){
                    dp[i][j] = Math.max( -prices[i] + dp[i + 1][1]  , dp[i + 1][0]); 
                }else if(j == 1 && i < n + 1 ){
                    dp[i][j] = Math.max(prices[i] + dp[i + 2][0] , dp[i + 1 ][1]);
                }
            }
        }

        return dp[0][0];
    }
}

/*class Solution {
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
}*/