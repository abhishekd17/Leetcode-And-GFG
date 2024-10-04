class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;

        int maxi = 1;
        int cnt=1;
        for(int i = 1 ; i < n ;i++){
            if(nums[i] > nums[i - 1]){
                cnt++;
            }else{
                maxi = Math.max(cnt , maxi);
                cnt = 1;
            }
        }
        return Math.max(cnt , maxi);
    }
}