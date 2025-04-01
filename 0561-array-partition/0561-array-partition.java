class Solution {
    public int arrayPairSum(int[] nums) {
        int n = nums.length , ans = 0;
        Arrays.sort(nums);
        for(int i = 0 ; i < n - 1 ; i +=2 ){
            ans += Math.min(nums[i] , nums[i + 1]);
        }
        return ans;
    }
}