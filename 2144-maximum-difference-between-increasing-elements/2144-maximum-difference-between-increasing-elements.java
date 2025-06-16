class Solution {
    public int maximumDifference(int[] nums) {
        int ans = -1;
        int n = nums.length;
        int mini = nums[0];

        for(int i = 1 ; i < n ; i++){
            ans = Math.max(ans , nums[i] - mini);
            mini = Math.min(mini , nums[i]);
        }
        return ans == 0 ? -1 : ans;
    }
}