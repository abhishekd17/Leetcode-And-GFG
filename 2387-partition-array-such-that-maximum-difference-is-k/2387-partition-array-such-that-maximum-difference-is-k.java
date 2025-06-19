class Solution {
    public int partitionArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int mini = nums[0];
        int cnt = 1;
        for(int i = 1 ; i < n ; i++){
            if(nums[i] - mini > k){
                cnt++;
                mini = nums[i];
            }
        }
        return cnt;
    }
}