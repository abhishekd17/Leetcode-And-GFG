class Solution {
    public double soupServings(int n) {
        if (n >= 5000)
            return 1.0;
        double dp[][] = new double[n + 1][n + 1];
        for (double[] x : dp)
            Arrays.fill(x, -1.0);
        return helper(n, n, dp);
    }

    private double helper(int a, int b, double[][] dp) {
        if (a <= 0 && b <= 0)
            return 0.5;
        if (a <= 0)
            return 1.0;
        if (b <= 0)
            return 0.0;
        if (dp[a][b] != -1.0)
            return dp[a][b];
        double cnt = 0.0;
        cnt += (helper(a - 100, b, dp));
        cnt += (helper(a - 75, b - 25, dp));
        cnt += (helper(a - 50, b - 50, dp));
        cnt += (helper(a - 25, b - 75, dp));
        return dp[a][b] = 0.25 * cnt;
    }
}