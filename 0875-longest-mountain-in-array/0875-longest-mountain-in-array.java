class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        if(n < 3) return 0;
        int dp1[] = new int[n];
        int dp2[] = new int[n];

        Arrays.fill(dp1 , 1);
        Arrays.fill(dp2 , 1);
        // LIS (Longest Increasing Subsequence)
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                dp1[i] = dp1[i - 1] + 1;
            }
        }

        // LDS (Longest Decreasing Subsequence)
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                dp2[i] = dp2[i + 1] + 1;
            }
        }
        int ans = 0;
        for(int i = 1 ; i < n - 1 ; i++){
            if(dp1[i] > 1 && dp2[i] > 1){
                ans =Math.max(ans , dp1[i] + dp2[i] - 1);
            }
        }

        return ans ;
    }
}