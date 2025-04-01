class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int maxi = Integer.MIN_VALUE;
        int l = 0 , r = n - 1;
        while(l < r){
            maxi = Math.max(maxi , nums[l] + nums[r]);
            l++;
            r--;
        }
        return maxi;
    }
}