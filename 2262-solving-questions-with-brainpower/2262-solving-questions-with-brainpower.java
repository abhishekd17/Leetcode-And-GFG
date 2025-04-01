class Solution {
    public long mostPoints(int[][] nums) {
        int n = nums.length;

        long dp[] = new long[n + 1];
        
        for(int i = n - 1 ; i >= 0 ; i--){
            long not_pick = dp[i + 1];
            long pick = nums[i][0];
            int next = nums[i][1] + i + 1 ;
            if(next <= n ){
                pick += dp[next];
            }
            dp[i] = Math.max(pick , not_pick);
        }
        return dp[0];
    }
}

/*class Solution {
    public long mostPoints(int[][] nums) {
        int n = nums.length;
        long dp[] = new long[n];
        Arrays.fill(dp , -1);
        return helper(nums , 0 , dp);
    }
    private long helper(int[][] nums , int ind , long dp[]){
        if(ind >= nums.length) return 0;
        if(dp[ind] != -1) return dp[ind];
        // skip
        long not_pick = helper(nums , ind + 1 , dp);

        // add
        long pick = 0;
        if(ind < nums.length ){
            pick = helper(nums , ind + nums[ind][1] + 1 , dp) + nums[ind][0];
        }
        return dp[ind] = Math.max(pick , not_pick);
    }
} */