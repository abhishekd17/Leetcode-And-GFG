/*class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int dp1[] = new int[n];
        int dp2[] = new int[n];
        Arrays.fill(dp1 ,1);
        Arrays.fill(dp2 , 1);
        int nums1[]= new int[n];
        for(int i = 0 ; i < n ; i++){
            nums1[i] = nums[n - i -1];
        }
        lis(nums,dp1);
        lis(nums1,dp2);
        reverse(dp2);
        int cnt1 = 0 , cnt2 =0;
        for(int i = 0 ; i < n ; i++){
            if(dp1[i] == 1) cnt1++;
            if(dp2[i] == 1) cnt2++;
        }
        if(cnt1 == n || cnt2 == n) return 0;
        int maxMountainLength = 0;
        for (int i = 1; i < n - 1; i++) {  
            if (dp1[i] > 1 && dp2[i] > 1) {  
                maxMountainLength = Math.max(maxMountainLength, dp1[i] + dp2[i] - 1);
            }
        }
        return n - maxMountainLength;
    }
     private void lis(int nums[] , int dp[]){
        int n = nums.length;
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < i ;j++){
                if(nums[i] > nums[j] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }
        }
    }

    private void reverse(int arr[]){
        int i = 0 ;
        int j = arr.length -1;
        while(i <= j){
            int temp =arr[i];
            arr[i] = arr[j];
            arr[j] =temp;
            i++;
            j--;
        }
    }
}*/
class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int dp1[] = new int[n];  // For Longest Increasing Subsequence (LIS)
        int dp2[] = new int[n];  // For Longest Decreasing Subsequence (LDS)
        
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        
        // Compute LIS for each index
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp1[i] < dp1[j] + 1) {
                    dp1[i] = dp1[j] + 1;
                }
            }
        }

        // Compute LDS for each index
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j] && dp2[i] < dp2[j] + 1) {
                    dp2[i] = dp2[j] + 1;
                }
            }
        }

        // Find the longest mountain subsequence
        int maxMountainLength = 0;
        for (int i = 1; i < n - 1; i++) {  // Peak cannot be at index 0 or n-1
            if (dp1[i] > 1 && dp2[i] > 1) {  // Both increasing and decreasing
                maxMountainLength = Math.max(maxMountainLength, dp1[i] + dp2[i] - 1);
            }
        }

        // Minimum removals is total length minus the longest mountain subsequence
        return n - maxMountainLength;
    }
}
