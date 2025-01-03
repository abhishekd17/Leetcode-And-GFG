class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for(int i = 0 ; i < n ; i++){
            sum += nums[i];
        }
        long currSum = 0;
        int ans = 0;
        for(int i = 0 ; i < n - 1; i++){
            currSum += nums[i];
            if(currSum >= sum - currSum){
                ans++;
            }
        }
        return ans;
    }
}