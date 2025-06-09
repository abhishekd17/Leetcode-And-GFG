class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[k + 1][n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[0][i][j] = 1.0;
            }
        }

        int[][] directions = {
            {-2, +1}, {-1, +2}, {+1, +2}, {+2, +1},
            {-2, -1}, {-1, -2}, {+1, -2}, {+2, -1}
        };

        for (int moves = 1; moves <= k; moves++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    double prob = 0.0;
                    for (int[] dir : directions) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];
                        if (ni >= 0 && nj >= 0 && ni < n && nj < n) {
                            prob += dp[moves - 1][ni][nj];
                        }
                    }
                    dp[moves][i][j] = prob / 8.0;
                }
            }
        }

        return dp[k][row][column];
    }
}


/*class Solution {
    public double knightProbability(int n, int k, int r, int c) {
        double dp[][][] = new double[k + 1][n][n];
        for(double a[][] : dp) for(double b[] : a) Arrays.fill(b , -1);
        return helper(n, k, r, c , dp);
    }

    private double helper(int n, int k, int r, int j , double dp[][][]) {
        if (r < 0 || j < 0 || r >= n || j >= n)
            return 0;
        if (k == 0)
            return 1;
        if(dp[k][r][j] != -1) return dp[k][r][j];
        double cnt = 0;
        cnt += helper(n, k - 1, r - 2, j + 1, dp);
        cnt += helper(n, k - 1, r - 1, j + 2, dp);
        cnt += helper(n, k - 1, r + 1, j + 2, dp);
        cnt += helper(n, k - 1, r + 2, j + 1, dp);
        cnt += helper(n, k - 1, r - 2, j - 1, dp);
        cnt += helper(n, k - 1, r - 1, j - 2, dp);
        cnt += helper(n, k - 1, r + 1, j - 2, dp);
        cnt += helper(n, k - 1, r + 2, j - 1, dp);

        return dp[k][r][j] = cnt / 8.0;
    }
} */