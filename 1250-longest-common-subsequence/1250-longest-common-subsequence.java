class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int prev[] = new int[m + 1];

        for(int i = 1 ; i <=n ; i++){
            int curr[]=new int[m + 1];
            for(int j = 1 ; j <= m ; j++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                   curr[j] = 1 + prev[j - 1];
                }else{
                    curr[j] = Math.max(prev[j] , curr[j - 1]);
                }
            }
            prev = curr;
        }

        return prev[m];
    }
}

/*class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][]=new int[n + 1][m + 1];
        for(int i = 0  ; i <= n ;i++){
            dp[i][0] = 0;
        }
        for(int i = 0 ; i <= m ;i++){
            dp[0][i] = 0;
        }

        for(int i = 1 ; i <= n ; i++ ){
            for(int j = 1 ; j <= m ;j++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                  dp[i][j] = 1 + dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j] , dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];

    }
}*/


/*class Solution {
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
} */