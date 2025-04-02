class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long ans = 0;
        for(int i = 0 ; i < n; i++){
            for(int j = i + 1 ; j < n ; j++){
                for(int k = j + 1 ; k < n ; k++){
                    long x = (nums[i] - nums[j]) * nums[k];
                    if(x < 0) x = 0;
                    ans = Math.max(ans , x);
                }
            }
        }
        return ans;
    }
}