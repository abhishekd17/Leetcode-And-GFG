class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;

        for(int i = 0 ; i < k ; i++){
            int mini = Integer.MAX_VALUE;
            int idx = 0;
            for(int j = 0 ; j < n ; j++){
                if(nums[j] < mini){
                    mini = nums[j];
                    idx = j;
                }
            }
            nums[idx] *= multiplier;
        }
        return nums;
    }
}