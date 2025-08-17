/*class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int prev[][] = new int[2][3];
        
        for(int i = n - 1 ; i >= 0 ; i--){
            int curr[][] = new int[2][3];
            for(int j = 0 ; j <= 1 ; j++){
                for(int k = 1 ; k <= 2 ; k++){
                    if(j == 0 ){
                        curr[j][k] = Math.max(-prices[i] + prev[1][k] , prev[0][k]);
                    }else{
                        curr[j][k] = Math.max(prices[i] + prev[0][k-1] , prev[1][k]);
                    }
                }
            }
            prev = curr;
        }
        return prev[0][2];
    }
}
*/


/*class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n + 1][2][3];
        
        for(int i = n - 1 ; i >= 0 ; i--){
            for(int j = 0 ; j <= 1 ; j++){
                for(int k = 1 ; k <= 2 ; k++){
                    if(j == 0 ){
                        dp[i][j][k] = Math.max(-prices[i] + dp[i + 1][1][k] , dp[i + 1][0][k]);
                    }else{
                        dp[i][j][k] = Math.max(prices[i] + dp[i + 1][0][k-1] , dp[i + 1][1][k]);
                    }
                }
            }
        }
        return dp[0][0][2];
    }
}
*/

class Solution {
    public int maxProfit(int[] prices) {
        int dp[][][] = new int[prices.length][2][3];
        for(int[][] aa : dp){
            for(int[] a :aa){
                Arrays.fill(a , -1);
            }
        }
        return helper(prices , 0 , 1 , 2 , dp);
    }
    private int helper(int price[] , int ind , int buy , int tran , int dp[][][]){
        //base case
        if(tran == 0) return 0;
        if(ind == price.length) return 0;
        if(dp[ind][buy][tran] != -1) return dp[ind][buy][tran];
        // buy ==  1  && sell == 0
        
        if(buy == 1 ){
            dp[ind][buy][tran] = Math.max(helper(price , ind + 1 , 0 , tran , dp ) - price[ind] , helper(price , ind + 1 , 1 , tran ,dp));
        }else {
            dp[ind][buy][tran] = Math.max(helper(price , ind + 1 , 1 , tran - 1 , dp) + price[ind] , helper(price , ind + 1 , 0 , tran , dp));
        }
        return dp[ind][buy][tran];
    }
} 