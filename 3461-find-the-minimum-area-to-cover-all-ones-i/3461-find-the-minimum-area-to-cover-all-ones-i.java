class Solution {
    public int minimumArea(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int top = Integer.MAX_VALUE , bottom = -1 , left = Integer.MAX_VALUE , right = -1;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    top = Math.min(top , i);
                    bottom = Math.max(i , bottom);
                    left = Math.min(left , j);
                    right = Math.max(right , j);
                }
            }
        }
        return (bottom - top + 1) * (right - left + 1);
    }
}


// 0 0 1 0 0 
// 0 1 0 0 0
// 0 0 1 0 0
// 0 0 0 1 0
// 0 0 0 0 0

// top = 0 , left = 1 , right = 3 , bottom = 3
// (bottom - top + 1) * (right - left + 1)
// (3 - 0 + 1) * (3 - 1 + 1)
// (4 * 3) == 12


// 0 1 0
// 1 0 1
// top = 0 , bottom = 1 , left = 0 , right = 2
// 2 * 3