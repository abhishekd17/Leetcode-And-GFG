class Solution {
    public int countSquares(int[][] a) {
        int res = 0;
        for(int i = 0 ; i < a.length ; i++){
            for(int j = 0 ; j < a[0].length; j++){
                if(a[i][j] > 0 && i > 0 && j > 0){
                    a[i][j] = Math.min(a[i - 1][j - 1]  ,  Math.min(a[i - 1][j] , a[i][j -1])) + 1;
                }
                res += a[i][j];
            }
        }
        return res;
    }
}

/*class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = 0;
        int dp[][] = new int[n + 1][m + 1];
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ;j++){
                if(matrix[i - 1][j - 1]==1){
                    dp[i][j] =  Math.min(dp[i - 1][j - 1]  ,  Math.min(dp[i - 1][j] , dp[i][j -1])) + 1;
                    ans += dp[i][j];
                }
            }
        }
        return ans;
    }
} */