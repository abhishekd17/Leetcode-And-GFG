class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n + 1];
        for(int[] a : dp) Arrays.fill(a , -1);
        return helper(nums, n - 1 , -1 , dp);
    }
    private int helper(int[] nums ,int ind , int prev , int dp[][]){
        // base case
        if(ind < 0) return 0;
        if(dp[ind][prev + 1] != -1) return dp[ind][prev + 1];
        // not_pick
        int not_pick = helper(nums , ind - 1 , prev, dp);
        // pick
        int pick = Integer.MIN_VALUE;
        if(prev == -1 || ( nums[prev ] > nums[ind])){
            pick = 1+ helper(nums , ind - 1 , ind, dp);
        }
        return dp[ind][prev + 1]= Math.max(pick , not_pick);
    }
}