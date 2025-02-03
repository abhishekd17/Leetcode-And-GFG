class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        if(n == 1) return nums[0];
        for(int i = 0 ; i < n ; i++){
            int cnt1 = 1 , cnt2 = 1;
            for(int j = i ; j < n - 1; j++){
                if(nums[j] > nums[j  + 1]){
                    cnt1++;
                }else{
                    cnt1 = 1;
                }

                if(nums[j] < nums[j + 1]){
                    cnt2++;
                }else{
                    cnt2 = 1;
                }

                ans = Math.max(ans , Math.max(cnt1 , cnt2));
            }
        }
        return ans;
    }
}