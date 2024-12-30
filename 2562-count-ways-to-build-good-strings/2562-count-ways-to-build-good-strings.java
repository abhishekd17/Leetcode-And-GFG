class Solution {
    private final int MOD = 1000000007;

    public int countGoodStrings(int low, int high, int zero, int one) {

        int dp[] = new int[100000 + 1];
        Arrays.fill(dp ,  -1);

        return helper(low , high , zero , one , 0 , dp) % MOD;
    }
    private int helper(int low , int high , int zero , int one , int len , int dp[]){
        int result = 0;

        if(len > high) return 0;
        if(dp[len] != -1) return dp[len];
        dp[len] = result = helper(low , high , zero , one , len + zero , dp) % MOD + helper(low , high ,zero,one , len + one , dp) % MOD 
                 + (int)((low <= len && len <= high) ? 1 : 0);
        return result;
    }

}