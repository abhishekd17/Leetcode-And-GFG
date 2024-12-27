class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    int drow[] = {-1,0,1,0};
                    int dcol[] = {0,1,0,-1};
                    for(int k = 0 ; k < 4 ; k++){
                        int nrow = i + drow[k];
                        int ncol = j + dcol[k];
                        if(nrow < 0 || nrow >= n || ncol < 0 || ncol >= m){
                            ans++;
                        }
                        if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 0){
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}