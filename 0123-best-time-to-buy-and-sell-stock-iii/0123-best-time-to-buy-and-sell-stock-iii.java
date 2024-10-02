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
        }else if(buy == 0 && tran <= 4){
            dp[ind][buy][tran] = Math.max(helper(price , ind + 1 , 1 , tran - 1 , dp) + price[ind] , helper(price , ind + 1 , 0 , tran , dp));
        }
        return dp[ind][buy][tran];
    }
}