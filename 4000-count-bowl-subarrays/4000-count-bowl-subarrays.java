class Solution {
    public long bowlSubarrays(int[] nums) {
        int n = nums.length;
        long ans = 0;
        // for (int i = 0; i < n - 2; i++) {
        //     int maxi = 0;
        //     for (int j = i + 1; j < n; j++) {
        //         int minBorder = Math.min(nums[i] , nums[j]);
        //         if(j >= i + 2 ){
        //             maxi = Math.max(maxi , nums[j - 1]);
        //         }
        //         if (j - i + 1 >= 3 && minBorder > maxi) {
        //             ans++;
        //         }
        //     }
        // }
        int pref[] = new int[n];
        int suff[] = new int[n];
        pref[0] = nums[0];
        suff[n - 1] = nums[n - 1];

        for(int i = 1 ; i < n ; i++){
            pref[i] = Math.max(nums[i] , pref[i -1]);
        }
        for(int i = n - 2 ; i >= 0 ; i--){
            suff[i] = Math.max(nums[i] , suff[i + 1]);
        }

        for(int i = 0 ; i < n ; i++){
            if(nums[i] < pref[i] && nums[i] < suff[i]) ans++;
        }
        return ans;
    }
}
