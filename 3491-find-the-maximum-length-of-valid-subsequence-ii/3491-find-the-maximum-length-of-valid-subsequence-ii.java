class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int dp[][] = new int[k][n];
        int maxi = 1;
        
        for (int i = 0; i < n; i++) {
            for (int mod = 0; mod < k; mod++) {
                dp[mod][i] = 1;
            }
        }
        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                int mod = ( nums[i] + nums[j] ) % k;
                dp[mod][i] = Math.max(dp[mod][i] , 1 + dp[mod][j]);
                maxi = Math.max(dp[mod][i] , maxi);
            }
        }
        return maxi;
    }
}