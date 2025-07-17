class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[1001][n];
        int maxi = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 1001; j++) {
                dp[j][i] = 1;
            }
        }
        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                int x = nums[i] - nums[j];
                x = x + 500;
                dp[x][i] = Math.max(dp[x][i] , dp[x][j] + 1);
                maxi = Math.max(maxi , dp[x][i]);
            }
        }
        return maxi;
    }
}