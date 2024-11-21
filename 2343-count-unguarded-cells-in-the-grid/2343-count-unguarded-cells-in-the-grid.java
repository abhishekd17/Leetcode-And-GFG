class Solution {
    public int countUnguarded(int n, int m, int[][] guards, int[][] walls) {
        int x = guards.length;
        int y = walls.length;
        int mat[][] = new int[n][m];

        // Mark guards and walls
        for (int i = 0; i < x; i++) {
            mat[guards[i][0]][guards[i][1]] = 1; // 1 for guards
        }
        for (int i = 0; i < y; i++) {
            mat[walls[i][0]][walls[i][1]] = -1; // -1 for walls
        }

        int vis[][] = new int[n][m]; // Visibility matrix
        int drow[] = {-1, 0, 1, 0}; // Directions for rows
        int dcol[] = {0, 1, 0, -1}; // Directions for columns

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) { // If the current cell is a guard
                    vis[i][j] = 1; // Mark the guard as visible

                    // Traverse in all 4 directions
                    for (int k = 0; k < 4; k++) {
                        int nrow = i;
                        int ncol = j;

                        // Move in the current direction
                        while (true) {
                            nrow += drow[k];
                            ncol += dcol[k];

                            // Boundary and stopping conditions
                            if (nrow < 0 || nrow >= n || ncol < 0 || ncol >= m || mat[nrow][ncol] == 1 || mat[nrow][ncol] == -1) {
                                break;
                            }

                            vis[nrow][ncol] = 1; // Mark cell as visible
                        }
                    }
                }
            }
        }

        // Count unguarded cells
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && mat[i][j] == 0) { // Not visible and not a wall/guard
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
