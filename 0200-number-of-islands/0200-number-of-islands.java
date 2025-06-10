class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;


        int numberOfIslands = 0;
        
        for(int i = 0 ; i < n ;i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == '1'){
                    helper(grid , i , j);
                    numberOfIslands++;
                }
            }
        }
        return numberOfIslands;
    }

    private void helper(char[][] grid , int i , int j){
        int n = grid.length;
        int m = grid[0].length;

        if(i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == '0') return;
        grid[i][j] = '0';

        helper(grid , i - 1 , j );
        helper(grid , i , j + 1);
        helper(grid , i + 1 , j);
        helper(grid , i , j - 1);

    }
}