class Solution {
    public long maxProduct(int[] nums) {
        int maxVal = 0;
        
        for(int num : nums) maxVal = Math.max(num, maxVal);
        
        int max_bits =32 - Integer.numberOfLeadingZeros(maxVal);
        
        int dp[] = new int[1 << max_bits];
        
        for(int num : nums) dp[num] = num;
        
        for(int i = 1 ; i < (1 << max_bits); i++){
            for(int j = 0 ; j < max_bits ; j++){
                if(((i>>j) & 1) == 1){
                    dp[i] = Math.max(dp[i] , dp[i^ (1 << j)]);
                }
            }
        }
        long ans = 0;
        for(int x : nums){
            int complement = ((1 << max_bits) - 1) & (~x);
            int y = dp[complement];
            ans = Math.max(ans , x * 1L * y);
        }
        return ans;
    }
}