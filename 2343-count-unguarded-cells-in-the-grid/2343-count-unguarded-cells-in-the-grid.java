class Solution {
    public int countUnguarded(int n, int m, int[][] guards, int[][] walls) {
        int x = guards.length;
        int y = walls.length;
        int mat[][] = new int[n][m];

        for (int i = 0; i < x; i++) {
            mat[guards[i][0]][guards[i][1]] = 1; 
        }
        for (int i = 0; i < y; i++) {
            mat[walls[i][0]][walls[i][1]] = -1; 
        }

        int vis[][] = new int[n][m]; 
        int drow[] = {-1, 0, 1, 0}; 
        int dcol[] = {0, 1, 0, -1}; 

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) { 
                    vis[i][j] = 1; 

                    for (int k = 0; k < 4; k++) {
                        int nrow = i;
                        int ncol = j;

                        while (true) {
                            nrow += drow[k];
                            ncol += dcol[k];

                            if (nrow < 0 || nrow >= n || ncol < 0 || ncol >= m || mat[nrow][ncol] == 1 || mat[nrow][ncol] == -1) {
                                break;
                            }

                            vis[nrow][ncol] = 1; 
                        }
                    }
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && mat[i][j] == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
