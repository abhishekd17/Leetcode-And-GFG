class Solution {
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
}