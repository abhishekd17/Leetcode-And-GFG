class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int maxi = 0;
        for(int i = 0 ; i < n ; i++) maxi = Math.max(maxi , nums[i]);

        int ans = 0;
        int i = 0;
        while(i < n ){
            int cnt = 0;
            if(nums[i] != maxi){
                i++;
                continue;
            }else{
                while(i < n && nums[i] == maxi){
                    cnt++;
                    i++;
                }
            }
            ans = Math.max(ans , cnt);
        }
        return ans;
    }
}