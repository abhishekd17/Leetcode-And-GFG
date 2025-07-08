class Solution {
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events , (a , b) -> Integer.compare(a[0] , b[0]));
        
        int dp[][] = new int[n][k + 1];
        for(int a[] : dp) Arrays.fill(a , -1);
        return helper(events , k , 0 , dp);
    }
    private int helper(int[][] events,int k , int ind , int dp[][]){
        if(ind >= events.length || k == 0 ) return 0;
        if(dp[ind][k] != -1) return dp[ind][k]; 

        int next = bs(events , ind + 1 , events[ind][1]);

        int p = events[ind][2] + helper(events , k - 1, next, dp); 
        int np = helper(events , k , ind + 1 , dp);
        return dp[ind][k] = Math.max(p , np);
    }
    private int bs(int events[][] , int l , int end){
        int r = events.length;
        while(l < r){
            int mid = l + ( r - l) / 2;
            if(events[mid][0] > end){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
}