class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()][word2.length()];
        for(int[] p : dp){
            Arrays.fill(p , -1);
        }
        return helper(word1 , word2 , word1.length() - 1 , word2.length() - 1 , dp);
    }

    private int helper(String s1 , String s2 , int i , int j ,int dp[][]){
        // base case
        if(i < 0 ) return j + 1 ;
        if(j < 0 ) return i + 1;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            dp[i][j]= helper(s1 , s2 , i - 1 , j - 1 , dp);
            return  dp[i][j];
        }else{ // delete , replace , insert
            dp[i][j]= 1 + Math.min(helper(s1 , s2 , i - 1 , j, dp ) , Math.min(helper(s1 , s2 , i - 1 , j - 1 , dp) , helper(s1 , s2 , i , j - 1 , dp)));
            return dp[i][j];
        }
    }

}
/*class Solution {
    public int minDistance(String word1, String word2) {
        return helper(word1 , word2 , word1.length() - 1 , word2.length() - 1);
    }

    private int helper(String s1 , String s2 , int i , int j){
        // base case
        if(i < 0 ) return j + 1 ;
        if(j < 0 ) return i + 1;
        if(s1.charAt(i) == s2.charAt(j)){
            return helper(s1 , s2 , i - 1 , j - 1);
        }else{ // delete , replace , insert
            return 1 + Math.min(helper(s1 , s2 , i - 1 , j ) , Math.min(helper(s1 , s2 , i - 1 , j - 1) , helper(s1 , s2 , i , j - 1)));
        }
    }

} */