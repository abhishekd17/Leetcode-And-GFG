class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int len = 1;
        List<Integer> list= new ArrayList<>();
        list.add(nums[0]);

        for(int i = 1 ; i < n ;i++){
            if(nums[i] > list.get(list.size() - 1)){
                list.add(nums[i]);
                len++;
            }else{
                int ind = Collections.binarySearch(list , nums[i]);
                if(ind < 0){
                    ind = -ind - 1;
                }
                list.set(ind , nums[i]);
            }
        }
        return len;
    }
}



/*class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp ,1);

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[j] + 1 , dp[i]);
                }
            }
        }
        int ans = 0;
        for(int i = 0 ; i < n ;i++){
            ans = Math.max(dp[i] , ans);
        }
        return ans;
    }
}
*/

/*class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int prevv[] =new int[n + 1];
        for(int ind = n -1 ; ind >= 0 ; ind--){
            int curr[] = new int[n + 1];
            for(int prev = ind - 1 ; prev >= -1 ; prev-- ){
                int not_pick = prevv[prev + 1];
                int pick = 0;
                if(prev == -1 || nums[ind] > nums[prev]){
                    pick = 1 + prevv[ind + 1];
                }
                curr[prev + 1 ] = Math.max(pick  , not_pick);
            }
            prevv = curr;
        }
        return prevv[0];
    }
}*/

/*class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] =new int[n+1][n + 1];
        for(int ind = n -1 ; ind >= 0 ; ind--){
            for(int prev = ind - 1 ; prev >= -1 ; prev-- ){
                int not_pick = dp[ind + 1][prev + 1];
                int pick = 0;
                if(prev == -1 || nums[ind] > nums[prev]){
                    pick = 1 + dp[ind + 1][ind + 1];
                }
                dp[ind][prev + 1 ] = Math.max(pick  , not_pick);
            }
        }
        return dp[0][0];
    }
}*/

/*class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n + 1];
        for(int[] a : dp) Arrays.fill(a , -1);
        return helper(nums, 0 , -1 , dp);
    }
    private int helper(int[] nums ,int ind , int prev , int dp[][]){
        // base case
        if(ind ==  nums.length) return 0;
        if(dp[ind][prev + 1] != -1) return dp[ind][prev + 1];
        // not_pick
        int not_pick = helper(nums , ind + 1 , prev, dp);
        // pick
        int pick = Integer.MIN_VALUE;
        if(prev == -1 || ( nums[prev ] < nums[ind])){
            pick = 1+ helper(nums , ind + 1 , ind, dp);
        }
        return dp[ind][prev + 1]= Math.max(pick , not_pick);
    }
} */