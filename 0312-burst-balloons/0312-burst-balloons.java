class Solution {
    public int maxCoins(int[] nums) {
        int arr[] = new int[nums.length + 2];
        arr[0] = 1;
        arr[arr.length - 1] = 1;
        int n = arr.length;
        int dp[][] = new int[n][n];
        for(int[] a : dp) Arrays.fill(a , -1);
        for(int i = 0 ; i < nums.length ; i++){
            arr[i + 1]  = nums[i];
        }
        return helper(arr , 1 , nums.length , dp );
    }
    private int helper(int arr[] , int  l , int r , int[][] dp ){
        if(l > r) return 0;
        if(dp[l][r] != -1) return dp[l][r];
        int maxi = Integer.MIN_VALUE;
        for(int i = l ; i <= r  ; i++){
            int cost = ( arr[r + 1] * arr[l - 1] * arr[i] ) + helper(arr , l , i - 1 , dp) + helper(arr , i + 1 , r , dp);
            dp[l][r] =  maxi = Math.max(cost ,maxi);
        }
        return dp[l][r];
    }
}