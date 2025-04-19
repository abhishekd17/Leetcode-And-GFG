class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        long ans = 0;
        
        Arrays.sort(nums);
        
        for(int i = 0 ; i < n ; i++){
            int l = bs(nums , i + 1 , n - 1 , lower - nums[i]);
            int r = bl(nums , i + 1 , n - 1 , upper - nums[i]);
            if(l <= r) ans += (r - l + 1);
        }
        return ans;
    }

    private int bs(int nums[] , int l , int r , int target){
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }

    private int bl(int nums[] , int l , int r , int target){
        while(l <= r){
           int mid = l + (r - l) / 2;
           if(nums[mid] <= target) l = mid + 1;
           else r = mid - 1;
        }
        return r;
    }
}