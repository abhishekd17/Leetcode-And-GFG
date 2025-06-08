class Solution {
    public int lastStoneWeightII(int[] nums) {
        int n = nums.length;
        int total = 0 ;
        for(int num : nums) total += num;
        boolean dp[] = new boolean[total / 2 + 1];
        dp[0] = true;
        
        for(int x : nums){
            for(int sum = total / 2 ; sum >= x ; sum--){
                dp[sum] = dp[sum] || dp[sum - x];
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = total / 2 ; i >= 0; i--) if(dp[i]) return total - 2 * i;
        return 0;
    }
}

/*class Solution {
    public int lastStoneWeightII(int[] nums) {
        int n = nums.length;
        int sum  = 0;
        for(int x : nums) sum += x;
        int dp[][] = new int[n][sum + 1];
        for(int[] x : dp)Arrays.fill(x,-1);
        return helper(nums , 0 , 0 , sum , dp);
    }
    private int helper(int nums[] , int idx , int curr , int sum , int dp[][]){
        if(idx == nums.length) {
            int o = sum - curr;
            return Math.abs(curr - o);
        }
        if(dp[idx][curr] != -1) return dp[idx][curr];
        int pick = helper(nums , idx + 1 , curr + nums[idx] , sum , dp);
        int not_pick = helper(nums , idx + 1 , curr , sum, dp);
        return dp[idx][curr] =  Math.min(pick , not_pick);
    }
} */