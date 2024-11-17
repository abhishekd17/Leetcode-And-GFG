class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int sum = 0 , last = -1 , ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            sum += nums[i];

            while(sum >= target){
                ans = Math.min(ans , i - last);
                sum -= nums[++last];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}