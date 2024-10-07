class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[] = new int[arr.length];
        Arrays.fill(dp,-1);
        return helper(0 , arr , k , dp);
    }
    private int helper(int i , int arr[] , int k , int dp[]){
        if(i == arr.length) return 0;
        if(dp[i] != -1) return dp[i];
        int len = 0 , maxi = Integer.MIN_VALUE , maxAns = Integer.MIN_VALUE;
        for(int ind = i ; ind < Math.min(arr.length , i + k ) ; ind++){
            len++;
            maxi = Math.max(maxi , arr[ind]);
            int sum = (len * maxi ) + helper(ind + 1 , arr , k , dp);
            dp[i]=maxAns = Math.max(sum , maxAns);
        }
        return dp[i];
    }
}