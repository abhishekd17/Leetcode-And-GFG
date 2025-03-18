class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;

        int ans = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < i + 30 && j < n ; j++){
                if(isNice(nums , i , j)){
                    ans = Math.max(ans , j - i + 1);
                }else{
                    break;
                }
            }
        }
        return ans;
    }

    private boolean isNice(int nums[] , int i , int j){
        int mask = 0;
        for(int k = i ; k <= j ; k++){
            if((mask & nums[k]) != 0) return false;
            mask = mask | nums[k];
        }
        return true;
    }
}