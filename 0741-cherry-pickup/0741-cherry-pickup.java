class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][][] = new int[n][m][m];
        for(int[][] a : dp) for(int[] b : a) Arrays.fill(b , -1);
        return Math.max(0 , helper(grid , 0 , 0 , 0 , dp));
    }

    private int helper(int grid[][], int r1 , int c1 , int c2 , int dp[][][]){
        int n = grid.length;
        int m = grid[0].length;
        
        int r2 = r1 + c1 - c2;

        if(r1 >= n || r2 >= n || c1 >= m || c2 >= m || grid[r1][c1] == -1 || grid[r2][c2] == -1) return Integer.MIN_VALUE;
        if(r1 == n - 1 && c1 == m - 1) return grid[r1][c1];

        if(dp[r1][c1][c2] != -1) return dp[r1][c1][c2];
        int ans = 0;
        if(r1 == r2 && c1 == c2) ans += grid[r1][c1];
        else ans += grid[r1][c1] + grid[r2][c2];

        int maxi = Integer.MIN_VALUE;
        maxi = Math.max(maxi , helper(grid , r1 + 1 , c1 , c2 , dp));
        maxi = Math.max(maxi , helper(grid , r1 , c1 + 1 , c2 , dp));
        maxi = Math.max(maxi , helper(grid , r1 + 1 , c1 , c2 + 1 , dp));
        maxi = Math.max(maxi , helper(grid , r1 , c1 + 1 , c2 + 1 , dp));

        if(maxi == Integer.MIN_VALUE) dp[r1][c1][c2] = Integer.MIN_VALUE;
        else dp[r1][c1][c2] = maxi + ans;
        return dp[r1][c1][c2];
    }
}