class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean vis[][] = new boolean[n][m];

        int numberOfIslands = 0;
        
        for(int i = 0 ; i < n ;i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == '1' && vis[i][j] == false){
                    helper(grid , i , j , vis);
                    numberOfIslands++;
                }
            }
        }
        return numberOfIslands;
    }

    private void helper(char[][] grid , int i , int j , boolean[][] vis){
        int n = grid.length;
        int m = grid[0].length;

        if(i < 0 || i >= n || j < 0 || j >= m || vis[i][j] == true || grid[i][j] == '0') return;
        vis[i][j] = true;

        helper(grid , i - 1 , j , vis);
        helper(grid , i , j + 1, vis);
        helper(grid , i + 1 , j , vis);
        helper(grid , i , j - 1, vis);

    }
}