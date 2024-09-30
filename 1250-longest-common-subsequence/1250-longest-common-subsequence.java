class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int ind1 = text1.length();
        int ind2 = text2.length();
        int dp[][] = new int[ind1][ind2];
        for(int[] x : dp){
            Arrays.fill(x , -1);
        }
        return helper(ind1 - 1 , ind2 - 1 , text1 , text2 , dp);
    }
    private int helper(int ind1 , int ind2 , String text1 , String text2,int dp[][] ){
        if(ind1 < 0 || ind2 < 0 ) return 0;
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];
        if(text1.charAt(ind1) == text2.charAt(ind2)){
            dp[ind1][ind2] = 1 + helper(ind1 - 1 , ind2 - 1 , text1 , text2 , dp);
            return dp[ind1][ind2];
        } 
        dp[ind1][ind2] = Math.max(helper(ind1 -1 , ind2 , text1 , text2 ,dp) , helper(ind1 , ind2 - 1 , text1 , text2 , dp));
        return dp[ind1][ind2];
    }
}