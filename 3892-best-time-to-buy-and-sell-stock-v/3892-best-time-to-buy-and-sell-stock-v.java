class Solution {
    public long maximumProfit(int[] nums, int k) {
        int n = nums.length;
        long dp[][][] = new long[n][3][k + 1];
        for(long a[][] : dp) for(long b[] : a ) Arrays.fill(b , -1);
        return helper(nums , 0 , 0 , k,dp);
    }

    private long helper(int nums[] , int ind , int state , int k , long dp[][][]){
        if(ind == nums.length){
            if(k >= 0 && state == 0) return 0;
            else return Integer.MIN_VALUE;
        }
        if(dp[ind][state][k] != -1) return dp[ind][state][k];

        long p = Integer.MIN_VALUE , np =Integer.MIN_VALUE;
        if(k > 0){
            if(state == 0){
                p = Math.max(nums[ind] + helper(nums , ind + 1 , 2 , k , dp) , -nums[ind] + helper(nums , ind + 1 , 1 , k , dp));
            }else if(state == 1){
                p = nums[ind] + helper(nums , ind + 1 , 0 , k - 1 , dp);
            }else{
                p = -nums[ind] + helper(nums , ind + 1 , 0 , k - 1 , dp);
            }
        }
        np = helper(nums , ind + 1 , state , k , dp);
        return dp[ind][state][k] = Math.max(p , np);
    }
}