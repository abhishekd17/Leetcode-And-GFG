class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int currSum = 0;
        int maxSum = 0;
        
        for(int i = 0 ; i< n ; i++){
            currSum += nums[i];

            maxSum = Math.max(maxSum , Math.abs(currSum));
            if(currSum < 0) currSum = 0;
        }
        currSum = 0;
        for(int i = 0 ; i < n ;i++){
            currSum += nums[i];

            maxSum = Math.max(maxSum , Math.abs(currSum));
            if(currSum > 0) currSum = 0;
        }
        return maxSum;
    }
}