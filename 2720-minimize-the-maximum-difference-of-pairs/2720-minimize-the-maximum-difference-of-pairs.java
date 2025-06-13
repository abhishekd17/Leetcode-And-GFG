class Solution {
    public int minimizeMax(int[] nums, int p) {
        int n = nums.length;
        Arrays.sort(nums);
        int r = nums[n - 1] - nums[0];
        int l = 0 ;

        while(l <= r){
            int mid = l + (r - l) / 2;
            int x = helper(nums , mid );
            if(x >= p) r = mid - 1;
            else l = mid + 1;
        }
        return l;
    }

    private int helper(int nums[] , int diff){
        int n = nums.length;
        int cnt = 0;
        for(int i = 0 ; i < n - 1;){
            if(nums[i + 1 ] - nums[i] <= diff){
                i += 2;
                cnt++;
            }else i++;
        }
        return cnt;
    }
}