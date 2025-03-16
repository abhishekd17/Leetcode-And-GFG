class Solution {
    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        int l = Integer.MAX_VALUE , r = Integer.MIN_VALUE;

        for(int x : nums){
            l = Math.min(l , x);
            r = Math.max(r , x);
        }
        int ans = 0;
        while(l <= r){
            int mid = (l + r ) / 2;
            int cnt = 0;
            for(int i = 0 ; i < n ; ){
                if(nums[i] <= mid){
                    cnt++;
                    i += 2;
                }else{
                    i++;
                }
            }
            if(cnt >= k ){
                ans = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }
}


/*class Solution {
    int n ;
    public int minCapability(int[] nums, int k) {
        n = nums.length;
        int memo[][] = new int[n][k + 1];
        for(int a[] : memo) Arrays.fill(a , -1);
        return helper(nums , k , 0 , memo);
    }

    private int helper(int nums[] , int k , int ind , int memo[][]){
        if(k == 0) return 0;
        if(ind >= n) return Integer.MAX_VALUE;
        if(memo[ind][k] != -1) return memo[ind][k];
        int take = Math.max(nums[ind] , helper(nums , k - 1 , ind + 2 , memo));
        int not_take = helper(nums , k , ind + 1 , memo);

        return memo[ind][k] = Math.min(take , not_take);
    }
} */