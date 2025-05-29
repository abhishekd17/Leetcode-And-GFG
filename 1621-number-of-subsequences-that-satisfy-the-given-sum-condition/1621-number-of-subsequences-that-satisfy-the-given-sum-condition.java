class Solution {
    private int mod = 1000000007;
    public int numSubseq(int[] nums, int target) {
       int n = nums.length;
       Arrays.sort(nums);
       int l = 0 , r = n - 1;
       int pow[] = new int[n];
       pow[0] = 1;
       for(int i = 1 ; i < n ; i++){
        pow[i] = (pow[i - 1] * 2 ) % mod;
       }
       int ans = 0;
       while(l <= r){
        if(nums[l] + nums[r] <= target){
            ans = (ans + pow[r - l]) % mod;
            l++;
        }else{
            r--;
        }
       }
       return ans;
    }
}

/*class Solution {
    public int numSubseq(int[] nums, int target) {
        return helper(nums, target, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, false);
    }

    private int helper(int[] nums, int k, int idx, int maxi, int mini, boolean picked) {
        if (idx == nums.length) {
            if (!picked) return 0;
            return (maxi + mini) <= k ? 1 : 0;
        }

        int not_pick = helper(nums, k, idx + 1, maxi, mini, picked);

        int new_max = picked ? Math.max(maxi, nums[idx]) : nums[idx];
        int new_min = picked ? Math.min(mini, nums[idx]) : nums[idx];
        int pick = helper(nums, k, idx + 1, new_max, new_min, true);

        return pick + not_pick;
    }
}
 */