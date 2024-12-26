class Solution {
    public int findTargetSumWays(int[] nums, int d) {
        int n=nums.length;
        int sum=0;
        for(int num : nums ){
            sum+=num;
        }
        if(sum - d < 0 || (sum - d)%2==1 || sum + d < 0 ) return 0;
        int target = (sum + d) / 2;

        int prev[]=new int[target + 1];

        if(nums[0]==0) prev[0]=2;
        else prev[0]=1;

        if(nums[0]!=0 && nums[0] <= target) prev[nums[0]]=1;

        for(int i=1;i<n;i++){
            int curr[]=new int[target + 1];
            for(int j=0 ; j<=target ;j++){
                int n_p=prev[j];
                int p=0;
                if(j >= nums[i]){
                    p=prev[j - nums[i]];
                }

                curr[j]= n_p + p;
            }
            prev = curr;
        }

        return prev[target];
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