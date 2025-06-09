class Solution {
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
}