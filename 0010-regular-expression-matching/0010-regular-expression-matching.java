class Solution {
    int[][] dp;

    public boolean isMatch(String s, String p) {
        dp = new int[s.length()][p.length()];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(s, p, s.length() - 1, p.length() - 1);
    }

    private boolean helper(String s, String p, int i, int j) {
        // base cases
        if (i < 0 && j < 0) return true;
        if (j < 0) return i < 0;

        if (i < 0) {
            if (p.charAt(j) == '*') return helper(s, p, i, j - 2);
            return false;
        }

        if (dp[i][j] != -1) return dp[i][j] == 1;

        boolean match = false;

        // Case 1: '*' handling
        if (p.charAt(j) == '*') {
            if (j >= 1 && (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                match = helper(s, p, i, j - 2) || helper(s, p, i - 1, j);
            } else {
                match = helper(s, p, i, j - 2);
            }
        }
        // Case 2: normal char or '.'
        else if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            match = helper(s, p, i - 1, j - 1);
        }

        dp[i][j] = match ? 1 : 0;
        return match;
    }
}
