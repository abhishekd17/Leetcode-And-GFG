class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int freq[][] = new int[strs.length][2];
        int j = 0;
        for(String s : strs){
            int ones = 0 , zeros = 0;
            for(int i = 0 ; i < s.length() ; i++){
                if(s.charAt(i) == '0') zeros++; else ones++;
            }
            freq[j][0] = zeros;
            freq[j][1] = ones;
            j++;
        }

        int dp[][][] = new int[strs.length][m + 1][n + 1];
        for(int[][] x : dp) for(int a[] : x) Arrays.fill(a , -1);
        return helper(freq , m , n , 0 , dp);
    }
    private int helper(int freq[][] , int m , int n , int idx , int dp[][][]){
        if(idx == freq.length) return 0;
        if(dp[idx][m][n] != -1) return dp[idx][m][n];
        int not_pick  = helper(freq , m , n , idx + 1 , dp);
        int pick = Integer.MIN_VALUE;
        if(m -freq[idx][0] >= 0 && n - freq[idx][1] >= 0){
            pick = helper(freq , m - freq[idx][0] , n - freq[idx][1] , idx + 1 , dp) + 1;
        }
        return dp[idx][m][n] = Math.max(not_pick , pick);
    }
}