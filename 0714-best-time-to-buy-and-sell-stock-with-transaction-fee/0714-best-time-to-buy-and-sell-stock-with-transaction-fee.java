class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n =  prices.length;

        int[] prev= new int[2];

        for(int i = n - 1; i >=0 ; i--){
            int curr[] = new int[2];
            for(int j = 0 ; j <= 1 ; j++){
                if(j == 0 ){
                    curr[j] = Math.max(-prices[i] + prev[1] , prev[0] );
                }else{
                    curr[j] = Math.max(prices[i] - fee + prev[0] , prev[1]);
                }
            }
            prev = curr;
        }
        return prev[0];
    }
}
/*class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n =  prices.length;

        int[][] dp= new int[n + 1][2];

        for(int i = n - 1; i >=0 ; i--){
            for(int j = 0 ; j <= 1 ; j++){
                if(j == 0 ){
                    dp[i][j] = Math.max(-prices[i] + dp[i + 1 ][1] , dp[i + 1][0] );
                }else{
                    dp[i][j] = Math.max(prices[i] - fee + dp[i + 1 ][0] , dp[i + 1][1]);
                }
            }
        }
        return dp[0][0];
    }
}*/

/*class Solution {
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
} */