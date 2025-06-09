class Solution {
    private int mod = 1000000007;
    public int dieSimulator(int n, int[] rollMax) {
        int dp[][][] = new int[n + 1][7][16];
        for(int[][] a : dp) for(int[] b : a) Arrays.fill(b , -1);
        return helper(n , -1 , 0 , rollMax , dp);
    }

    private int helper(int n , int prev , int cnt , int nums[] , int [][][] dp){
        if(n == 0) return 1;
        int ans = 0;
        int off = prev + 1;
        if(dp[n][off][cnt] != -1) return dp[n][off][cnt];
        for(int i = 0 ; i < 6 ; i++){
            if(prev == (i) && cnt < nums[i]){
                ans = (ans + helper(n - 1 , i, cnt + 1 , nums, dp)) % mod;
            }else if(prev != i){
                ans = (ans + helper(n - 1 , i, 1 , nums,dp)) % mod;
            }
        }
        return dp[n][off][cnt] = ans;
    }
}