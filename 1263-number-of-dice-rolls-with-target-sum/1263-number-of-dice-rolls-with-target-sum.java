class Solution {
    private int mod = 1000000007;
    public int numRollsToTarget(int n, int K, int target) {
        int dp[][] = new int[n + 1][target + 1];
        dp[0][0] = 1;

        for(int d = 1 ; d <= n ; d++){
            for(int sum = 1; sum <= target; sum++){
                for(int k = 1 ; k <= K ; k++){
                    if(sum - k >= 0){
                        dp[d][sum] = (dp[d][sum] + dp[d - 1][sum - k]) % mod;
                    }
                }
            }
        }
        return dp[n][target] % mod;
    }
}

/*class Solution {
    private int mod = 1000000007;
    
    public int numRollsToTarget(int n, int k, int target) {
        int dp[][] = new int[n + 1][target + 1];
        for(int x[] : dp) Arrays.fill(x , -1);
        return helper(n , k , target, dp);
    }
    private int helper(int n , int k , int target , int[][] dp){
        if(n == 0 && target == 0 ) return 1;
        if(n == 0 || target < 0) return 0;
        if(dp[n][target] != -1) return dp[n][target];
        int cnt = 0;
        for(int i = 1 ; i <= k ; i++){
            cnt = (cnt + helper(n - 1 , k , target - i , dp)) % mod;
        }
        return dp[n][target] = cnt % mod;
    }
} */