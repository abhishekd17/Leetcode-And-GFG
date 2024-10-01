class Solution {
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
}