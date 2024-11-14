class Solution {
    public int maxDistance(int[] nums, int m) {
        int n = nums.length;
        Arrays.sort(nums);
        int l = 1;
        int r = (nums[n- 1 ] - nums[0]) / (m - 1);

        int ans = 0;
        while(l <= r){
            int mid = l + ( r - l ) / 2;
            if(possible(nums , m , mid)){
                ans = mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return ans;
    }

    private boolean possible(int nums[] , int m , int minDis){
        int cnt = 1;
        int lastPos = nums[0];
        for(int i = 1;  i < nums.length ; i++){
            if(nums[i] - lastPos >= minDis){
                cnt++;
                lastPos = nums[i];
                if(cnt == m) return true;
            }
        }
        return false;
    }
}