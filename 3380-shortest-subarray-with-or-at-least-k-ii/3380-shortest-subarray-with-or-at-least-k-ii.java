class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int arr[] = new int[32];
        int ans =Integer.MAX_VALUE;
        int i = 0  , j = 0;
        while(j < n ){
            update(nums[j] , arr , 1);
            while(i <= j && getBinaryToDecimal(arr) >= k){
                ans = Math.min(ans , j - i + 1);
                update(nums[i] , arr , -1);
                i++;
            }
            j++;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    private void update(int number , int arr[] , int val){
        for(int i = 0 ;i < 32 ;i++){
            if(((number >> i) & 1 ) == 1 ){
                arr[i] += val;
            }
        }
    }
    private int getBinaryToDecimal(int arr[]){
        int num = 0;
        for(int i = 0 ; i < 32 ; i++){
            if(arr[i] > 0){
                num |= (1 << i);
            }
        }
        return num;
    }
}