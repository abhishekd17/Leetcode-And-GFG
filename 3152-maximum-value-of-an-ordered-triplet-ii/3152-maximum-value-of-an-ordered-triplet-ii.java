class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long ans = 0 , maxEle = 0 , maxDiff = 0;

        for(int num : nums){
            ans = Math.max(ans , maxDiff * num);
            maxDiff = Math.max(maxDiff , maxEle - num);
            maxEle = Math.max(maxEle , num);
        }
        return ans;
    }
}