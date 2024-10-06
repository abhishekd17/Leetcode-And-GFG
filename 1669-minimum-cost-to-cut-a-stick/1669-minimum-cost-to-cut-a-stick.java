class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int arr[] = new int[cuts.length + 2];
        int nn = arr.length;
        arr[0] = 0;
        arr[nn - 1] = n;

        for(int i = 0 ; i < cuts.length ; i++){
            arr[i + 1] = cuts[i];
        }
        int dp[][] = new int[nn][nn];
        for(int[] a : dp) Arrays.fill(a , -1);
        return helper(arr , 1 , cuts.length , dp);
    }

    private int helper(int arr[] , int l , int r , int dp[][]){
        if(l > r) return 0;
        if(dp[l][r] != -1) return dp[l][r];
        int mini =Integer.MAX_VALUE;
        for(int i = l ; i <= r ; i++){
            int cost = arr[r + 1] - arr[l - 1] + helper(arr ,l , i - 1 , dp) + helper(arr , i + 1 , r , dp);
            dp[l][r] = mini = Math.min(cost , mini);
        }
        return dp[l][r];
    }
}