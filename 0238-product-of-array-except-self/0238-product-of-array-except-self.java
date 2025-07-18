class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];
        int zeros = 0;
        int x = 1;
        for(int i=0;i<n;i++){
            if(nums[i] == 0) zeros++;
            else x *= nums[i];
        }
        if(zeros > 1) return ans;

        if(zeros == 1){
            for(int i = 0 ; i < n ; i++){
                if(nums[i] != 0) ans[i] = 0;
                else ans[i] = x;
            }
        }else{
            for(int i = 0 ; i < n ; i++){
                ans[i] = x / nums[i];
            }
        }
        return ans;
    }
}