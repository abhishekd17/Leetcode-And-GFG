class Solution {
    public int numSquares(int n) {
        int x = (int)Math.sqrt(n);
        int dp[][] = new int[n + 1][x + 1];
        for(int a[] : dp) Arrays.fill(a , -1);
        return helper(n , x, dp);
    }
    private int helper(int n , int x , int dp[][]){
        if(n == 0) return 0;
        if(x == 0) return Integer.MAX_VALUE;
        if(dp[n][x] != -1) return dp[n][x];
        // not_pick 
        int np = helper(n , x - 1 , dp);
        int p = Integer.MAX_VALUE;
        if(n >= x * x){
            p = 1 + helper(n - (x * x) , x , dp);
        }
        return dp[n][x] = Math.min(np , p);
    }
}