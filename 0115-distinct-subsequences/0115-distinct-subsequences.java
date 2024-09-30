class Solution {
    static int prime = (int) (Math.pow(10, 9) + 7);
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int prev[] = new int[m + 1];

        prev[0] = 1;
        for(int i = 1 ; i <= n ;i++){
            int curr[] = new int[m + 1];
            curr[0]=1;
            for(int j = 1 ; j <= m ;j++){
               if(s.charAt(i - 1) == t.charAt(j - 1)){
                curr[j] = (prev[j - 1] + prev[j])%prime;
               }else{
                curr[j] = prev[j];
               }
            }
            prev = curr;
        }
        return prev[m];
    }
}
/*class Solution {
    static int prime = (int) (Math.pow(10, 9) + 7);
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int dp[][] = new int[n + 1 ][m + 1];

        for(int i = 0 ; i <= n ;i++){
            dp[i][0] = 1;
        }
        for(int i = 1 ; i <= m ;i++){
            dp[0][i] = 0;
        }
        for(int i = 1 ; i <= n ;i++){
            for(int j = 1 ; j <= m ;j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = (dp[i-1][j - 1] + dp[i-1][j]) % prime;
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }
} */

/*class Solution {
    public int numDistinct(String s, String t) {
        int dp[][]=new int[s.length()][t.length()];
        for(int[] a : dp){
            Arrays.fill(a , -1);
        }
        return helper(s , t , s.length() - 1 , t.length() - 1 , dp);
    }
    private int helper(String s  , String t , int ind1 , int ind2 , int dp[][]){
        if(ind2 < 0) return 1;
        if(ind1 < 0) return 0;
        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
        if(s.charAt(ind1) == t.charAt(ind2)){
            dp[ind1][ind2]  = helper(s , t , ind1 - 1 , ind2 - 1 , dp) + helper(s , t , ind1 - 1 , ind2 , dp);
            return dp[ind1][ind2];
        }else{
            dp[ind1][ind2] =  helper(s , t , ind1 - 1, ind2, dp);
            return dp[ind1][ind2];
        }
    }
} */