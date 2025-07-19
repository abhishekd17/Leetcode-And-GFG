class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int mini = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            if(i != 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = n - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(Math.abs(sum - target) < Math.abs(mini - target)) mini = sum;
                if(sum < target){
                    j++;
                }else if(sum > target){
                    k--;
                }else{
                    return target;
                }
            }
        }
        return mini;
    }
}