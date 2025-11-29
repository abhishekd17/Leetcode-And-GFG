class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length , sum = 0;
        for(int i = 0 ; i < n ; i++){
            sum += nums[i];
        }
        int ans = sum % k;
        return ans;
    }
}