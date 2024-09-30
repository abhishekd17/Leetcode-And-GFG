class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n + 1][m + 1];

        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j <= m ;j++){
                if(i == 0 || j == 0) dp[i][j] = 0;
                else dp[i][j] = (s1.charAt(i - 1 ) == s2.charAt(j - 1)) ? 1 + dp[i - 1][j - 1] : Math.max(dp[i - 1][j] , dp[i][j - 1]);
            }
        }

        int i = n ; 
        int j = m;
        StringBuilder s = new StringBuilder();
        while(i > 0 && j > 0 ){
            if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                s.append(s1.charAt(i - 1));
                i--;
                j--;
            }else if(dp[i - 1][j] > dp[i][j-1]){
                s.append(s1.charAt(i - 1));
                i--;
            }else{
                s.append(s2.charAt(j - 1));
                j--;
            }
        }

        while(i > 0 ){
            s.append(s1.charAt(i - 1));
            i--;
        }
        while(j > 0){
            s.append(s2.charAt(j - 1));
            j--;
        }

        return s.reverse().toString();
    }
}