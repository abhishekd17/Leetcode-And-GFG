class Solution {
    public long maximumMedianSum(int[] nums) {
        long ans = 0;
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0 , r = n - 1;
        while(l < r){
            ans += (nums[r - 1]);
            r -= 2;
            l++;
        }
        return ans;
    }
}