class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n =nums.length;
        int dp[] = new int[n];
        int cnt[] = new int[n];
        Arrays.fill(dp , 1);
        Arrays.fill(cnt , 1);
        int ans = 1;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                if(nums[i] > nums[j] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                    cnt[i] = cnt[j];
                }else if(nums[i] >= nums[j] && dp[i] == dp[j] + 1){
                    cnt[i] += cnt[j];
                }
            }
            ans = Math.max(ans , dp[i]);
        }
        int lis = 0 ;
        for(int i = 0 ; i < n ; i++){
            if(ans == dp[i]) lis += cnt[i];
        }
        return lis;
    }
}