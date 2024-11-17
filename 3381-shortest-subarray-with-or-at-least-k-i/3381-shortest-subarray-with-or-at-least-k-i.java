class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int ans = n + 1;
        int or = 0;
        for(int i = 0 ; i  < n ; i++){
            or = 0;
            for(int j = i ; j  < n ; j++){
                or |= nums[j];
                if(or >= k){
                    ans = Math.min(ans , j - i + 1);
                }
            }
        }
        return ans == n + 1 ? -1 : ans;
    }
}