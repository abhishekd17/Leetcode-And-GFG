class Solution {
    int n , m;
    int MOD = 1000000007;
    public int uniquePaths(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int dp[][][] = new int[n][m][3];
        for(int[][] a : dp) for(int[] b : a) Arrays.fill(b , -1);
        return helper(grid , 0 , 0 , 0 , dp);
    }

    private int helper(int grid[][] , int i , int j, int dir , int dp[][][]){
        // base condition
        if(i < 0 || j < 0 || i >= n || j >= m) return 0;
        if(i == n - 1 && j == m - 1 ) return 1;
        if(dp[i][j][dir] != -1) return dp[i][j][dir];
        
        int ways = 0;
        
        if(grid[i][j] == 1){
            if(dir == 1){
                ways = (ways + helper(grid , i + 1 , j , 2 , dp)) % MOD;
            }else{
                ways = (ways + helper(grid , i ,j + 1 , 1,dp )) % MOD;
            }
        }else{
            ways = (ways + helper(grid , i + 1 , j , 2 , dp) % MOD + helper(grid , i , j + 1 , 1 , dp) % MOD) % MOD;
        }
        dp[i][j][dir] = ways; 
        return dp[i][j][dir];
    }
}