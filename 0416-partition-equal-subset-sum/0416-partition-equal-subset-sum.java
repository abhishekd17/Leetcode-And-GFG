class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for(int num : nums) sum += num;

        if(sum % 2 != 0 ) return false;

        boolean dp[][] = new boolean[n][sum / 2 + 1];
        
        for(int i = 0 ; i < n ; i++){
            dp[i][0] = true;
        }

        if(nums[0] <= sum /2 ) dp[0][nums[0]] = true;

        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j <= sum / 2 ; j++){
                boolean not_pick = dp[i - 1][j];
                boolean pick = false;
                if(j >= nums[i]){
                    pick = dp[i - 1][j - nums[i]];
                }
                dp[i][j] = pick || not_pick;
            }
        }
        return dp[n - 1][sum / 2];
    }
}















/*class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        int target=sum/2;
        boolean prev[]=new boolean[target + 1];
            prev[0]=true;
            if(target >= nums[0]){
                prev[nums[0]]=true;
            }

            for(int i=1;i<n;i++){
                boolean[] curr=new boolean[target + 1];
                curr[0]=true;
                for(int j=1;j<=target ; j++){
                    boolean not_pick = prev[j];
                    boolean pick=false;
                    if(j>=nums[i]){
                        pick= prev[j-nums[i]];
                    }
                    curr[j]= pick || not_pick;
                }
                prev=curr;
            }
        return prev[target];
    }
}*/


/*class Solution {
    public boolean canPartition(int[] nums) {
    int total=0;
    int N=nums.length;
    for(int i=0;i<nums.length;i++) total+=nums[i];

    if(total%2!=0) return false;
    else{
    boolean dp[][]=new boolean[N][total/2 + 1];
        for(int i=0;i<N;i++){
            dp[i][0]=true;
        }
        if(nums[0]<=total/2){
            dp[0][nums[0]]=true;
        }
        
        for(int i=1;i<N;i++){
            for(int j=1 ;j<=total/2;j++){
                boolean not_pick = dp[i-1][j];
                boolean pick=false;
                if(j>=nums[i]){
                    pick=dp[i-1][j - nums[i]];
                }
                dp[i][j]=pick || not_pick;
            }
        }
        return dp[N - 1][total/2];
        }
    } 
}*/

/*class Solution {
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int i=0;i<nums.length;i++) total+=nums[i];
        Boolean dp[][]=new Boolean[nums.length][total/2  +  1];
        if(total%2!=0) return false;
        return helper(0 , nums , 0 , total/2 , dp);
    }

    private boolean helper(int ind , int[] nums , int sum , int total ,Boolean dp[][] ){
        // base case
        if(ind>=nums.length || sum > total) return false;
        if(sum==total) return true;
        if(dp[ind][sum]!=null) return dp[ind][sum];
        // pick or not pick
        boolean pick=false;
        if(nums[ind]<=total){
             pick = helper(ind + 1 , nums , sum + nums[ind] , total , dp);
        }

        boolean not_pick=helper(ind + 1 , nums , sum , total , dp);

        return dp[ind][sum] = pick || not_pick;

    }
}*/