class Solution {
    public int findTargetSumWays(int[] arr, int d) {
        int n = arr.length;
        int total = 0;
        
        for(int i = 0 ; i < n ; i++) total += arr[i];

        int tar = (total - d) / 2;
        if (total < d || (total + d) % 2 != 0) return 0;
        int dp[][] = new int[n + 1][tar + 1];
        for(int i = 0 ; i <= n ; i++) dp[i][0] = 1;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 0 ; j <= tar ; j++){
                int np = dp[i - 1][j];
                int p = 0;
                if(j >= arr[i - 1]){
                    p = dp[i - 1][j - arr[i - 1]];
                }
                
                dp[i][j] = p + np;
            }
        }
        return dp[n][tar];
    }
}


/*class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int maxi=0;
        for(int i=0;i<n;i++){
            maxi += nums[i];
        }
        int dp[][]=new int[n][2 * maxi + 1];
        for(int[] num :dp){
            Arrays.fill(num , -1);
        }
        return helper(nums , n - 1 , target + maxi , dp , maxi);
    }

    private int helper(int nums[] , int ind , int target , int dp[][] , int maxi){
        //  base case
        if(ind == -1){
            return target == maxi ? 1 : 0;
        }
        if(target < 0 || target > 2 * maxi ) return  0;

        if(dp[ind][target]!=-1) return dp[ind][target];
        // positive 
             int positive=helper(nums , ind - 1 , target - nums[ind] , dp , maxi);
             int negative = helper(nums , ind - 1 , target + nums[ind] , dp , maxi);
        dp[ind][target]= positive  +  negative;
        return dp[ind][target];
    }
}*/
/*class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;

        return helper(nums , n - 1 , target );
    }

    private int helper(int nums[] , int ind , int target ){
        //  base case
        if(ind == -1){
            return target==0 ? 1 : 0;
        }
        // positive 
             int positive=helper(nums , ind - 1 , target - nums[ind] );
             int negative = helper(nums , ind - 1 , target + nums[ind]);
        return positive  +  negative;
    }
} */