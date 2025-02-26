class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max = 0 , min = 0 , s = 0;
        for(int a : nums){
            s += a;
            max = Math.max(max , s);
            min = Math.min(min , s);
        }
        return max - min;
    }
}


/*class Solution {
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
} */