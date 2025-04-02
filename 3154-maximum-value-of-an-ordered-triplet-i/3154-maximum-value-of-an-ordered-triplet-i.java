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

/*class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long ans = 0;
        for(int i = 0 ; i < n; i++){
            for(int j = i + 1 ; j < n ; j++){
                for(int k = j + 1 ; k < n ; k++){
                    long x = (long)(nums[i] - nums[j]) * nums[k];
                    if(x > ans){
                        ans = x;
                    }
                }
            }
        }
        return ans > 0 ? ans : 0;
    }
} */