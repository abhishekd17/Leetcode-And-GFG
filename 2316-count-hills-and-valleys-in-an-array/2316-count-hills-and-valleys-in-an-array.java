class Solution {
    public int countHillValley(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        int i = 1 ;
        while(i < n - 1){
            int prev = i - 1;
            while(i < n - 1 &&  nums[i] == nums[i + 1]){
                i++;
            }

            if(i < n - 1 && ((nums[i] > nums[i + 1] && nums[i] > nums[prev]) || (nums[i] < nums[i + 1] && nums[i] < nums[prev]))) cnt++; 
            i++;
        }
        return cnt;
    }
}