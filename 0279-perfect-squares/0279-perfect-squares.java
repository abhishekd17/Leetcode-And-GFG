class Solution {
    public int numSquares(int n) {
        int x = (int) Math.sqrt(n);
        int dp[][] = new int[n + 1][x + 1];
        for(int i = 0 ; i <= x ; i++) dp[0][i] = 0;
        for(int i = 0 ; i <= n ; i++) dp[i][0] = Integer.MAX_VALUE;

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= x ; j++){
                int np = dp[i][j - 1];
                int p = Integer.MAX_VALUE;
                if(i >= j * j && dp[i - (j * j)][j] != Integer.MAX_VALUE){
                    p = 1 + dp[i - (j * j)][j];
                }
                dp[i][j] = Math.min(p , np);
            }
        }
        return dp[n][x];
    }
}


/*class Solution {
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
} */