class Solution {
    final int mod = 1000000007;
    int p;
    public int numberOfWays(int n, int x) {
        p = n;
        int dp[][] = new int[301][301];
        for(int a[] : dp) Arrays.fill(a , -1);
        return helper(1 , n , x , dp);
    }

    private int helper(int curr , int rem , int x , int dp[][]){
        if(rem == 0) return 1;
        if(rem < 0) return 0;
        if(curr > p ) return 0;
        if(dp[curr][rem] != - 1) return dp[curr][rem];

        int power = (int) Math.pow(curr , x);
        if(power > rem) return 0;

        int pick = helper(curr + 1 , rem - power , x ,dp) % mod;
        int not_pick = helper(curr + 1 , rem , x , dp) % mod;
        
        return dp[curr][rem] = (pick + not_pick) % mod;
    }
}