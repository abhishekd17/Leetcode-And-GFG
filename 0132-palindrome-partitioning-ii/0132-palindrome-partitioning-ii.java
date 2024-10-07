class Solution {
    public int minCut(String s) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp ,-1);
        return helper(0 ,  s , dp) - 1;
    }
    private int helper(int i , String s , int dp[]){
        if(i == s.length()) return 0;
        if(dp[i] != -1) return dp[i];
        int mini =Integer.MAX_VALUE;
        for(int j = i ; j < s.length() ; j++ ){
            if(isPalindrome(s.substring(i , j + 1))){
                int cnt = 1 + helper(j + 1 , s , dp);
                dp[i] = mini =Math.min(cnt , mini);
            }
        }
        return dp[i];
    }
    private boolean isPalindrome(String s){
        int i = 0 ;
        int j = s.length() - 1;
        while(i <= j){
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}



/*class Solution {
    public int minCut(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        for(int[] a : dp) Arrays.fill(a,-1);
        return helper(0 , s.length() - 1 , s, dp);
    }
    private int helper(int i , int j , String s , int dp[][]){
        if(i >= j || isPalindrome(s.substring(i , j + 1))) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for(int ind = i ; ind <= j ; ind++){
            if(isPalindrome(s.substring(i , ind + 1))){
                int cnt = 1 + helper(ind + 1 , j , s ,dp);
                mini = Math.min(cnt , mini);
            }
            dp[i][j] = mini;
        }
        return dp[i][j];
    }
    
    private boolean isPalindrome(String s){
        int i = 0 ;
        int j = s.length() - 1;
        while(i <= j){
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
} */