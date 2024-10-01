class Solution {
    private boolean isAllStars(String t , int i){
        for(int j = 0 ; j <= i  ;j++){
            if(t.charAt(j) != '*') return false;
        }
        return true;
    }
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean prev[] =  new boolean[m + 1];
        prev[0] = true;

        for(int i = 1 ; i <= m ; i++){
            if(isAllStars(p , i - 1)){
                prev[i] = true;
            }else{
                prev[i] = false;
            }
        }

        for(int i = 1 ; i <= n ;i++){
            boolean curr[] = new boolean[m + 1];
            for(int j = 1 ; j <= m ;j++){
               if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
                    curr[j] = prev[j - 1];
                }else{
                    if(p.charAt(j - 1) == '*'){
                        curr[j] = (prev[j] || curr[j - 1]);
                    }else{
                        curr[j] = false;
                    }
                } 
            }
            prev = curr;
        }
        return prev[m];
    }
}

/*class Solution {
    private boolean isAllStars(String t , int i){
        for(int j = 0 ; j <= i  ;j++){
            if(t.charAt(j) != '*') return false;
        }
        return true;
    }
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean dp[][] = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        for(int i = 1; i<= n ;i++){
            dp[i][0] = false;
        }
        for(int j = 1 ; j <= m ; j++){
            if(isAllStars(p , j - 1)){
                dp[0][j] = true;
            }else{
                dp[0][j] = false;
            }
        }

        for(int i = 1 ; i <= n ;i++){
            for(int j = 1 ; j <=m ;j++){
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    if(p.charAt(j - 1) == '*'){
                        dp[i][j] = (dp[i - 1][j] || dp[i][j - 1]);
                    }else{
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[n][m];
    }
}
*/

/*class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int dp[][] = new int[n][m];
        for(int[] a : dp) Arrays.fill(a , -1);
        return helper(s, p , n - 1 , m -1 , dp) == 1 ? true : false;
    }
    private boolean isAllStars(String t , int i){
        for(int j = 0 ; j <= i ;j++){
            if(t.charAt(j) != '*') return false;
        }
        return true;
    }
    private int helper(String s  , String t , int i , int j  , int dp[][]){
        // base case
        if(i < 0 && j <0) return 1;
        if(i >= 0  && j < 0 ) return 0;
        if(i < 0 && j >= 0 ) return isAllStars(t , j) ? 1 : 0 ;
        if(dp[i][j] != -1 ) return dp[i][j] ;
        if(s.charAt(i) == t.charAt(j) || t.charAt(j) =='?') return dp[i][j]= helper(s , t , i - 1 , j - 1 , dp);
        else{
            if(t.charAt(j) == '*'){
                return dp[i][j]= (helper(s , t , i - 1 , j , dp) == 1  || helper(s , t , i , j - 1 , dp) == 1 ) ? 1 : 0 ;
            }else{
                return 0;
            }
        }
    }
} */