class Solution {
    int drow[] = {-1 , 0, 1, 0};
    int dcol[] = {0 , 1 , 0 , -1};
    int n , m;
    public int longestIncreasingPath(int[][] mat) {
        n = mat.length;
        m = mat[0].length;
        int dp[][] = new int[n][m];
        
        for(int a[] : dp){
            Arrays.fill(a, -1);
        }

        int maxi = 0;
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                int x = helper(i , j , mat , dp);
                maxi = Math.max(maxi , x);
            }
        }
        return maxi;
    }

    private int helper(int i , int j , int mat[][] , int dp[][]){
        if(dp[i][j] != -1) return dp[i][j];
        
        int x = 1;
        
        for(int k = 0 ; k < 4 ; k++){
            int ni = i + drow[k];
            int nj = j + dcol[k];
            if(ni >= 0 && ni < n && nj >= 0 && nj < m && mat[ni][nj] > mat[i][j]){
                x = Math.max(x, 1 + helper(ni, nj, mat, dp));
            }
        }
        return dp[i][j] = x;
    }
}