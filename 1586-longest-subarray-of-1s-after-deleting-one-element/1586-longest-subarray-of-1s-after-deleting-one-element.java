class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        boolean allOne = true;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] != 1){
                allOne = false;
                break;
            }
        }
        if(allOne) return n - 1;
        
        int ans = 0, beforeZero = 0 , afterZero = 0;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] == 1){
                afterZero++;
            }else{
                ans = Math.max(ans , beforeZero + afterZero);
                beforeZero = afterZero;
                afterZero = 0;
            }
        }
        ans = Math.max(ans , beforeZero + afterZero);

        return ans;
    }
}