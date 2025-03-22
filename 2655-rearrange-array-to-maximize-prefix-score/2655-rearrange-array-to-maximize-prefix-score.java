class Solution {
    public int maxScore(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);
        reverse(nums);
        long sum = 0;
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            sum += nums[i];
            if(sum > 0) ans++;
            else break;
        }
        return ans;
    }

    private void reverse(int nums[]){
        int l = 0 , r = nums.length - 1;
        while(l <= r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}