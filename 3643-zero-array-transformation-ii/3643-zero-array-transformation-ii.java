class Solution {

    private boolean helper(int nums[] , int[][] queries , int k){
        int a[] = new int[nums.length];

        for(int i = 0 ; i <= k ; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            int x = queries[i][2];

            a[l] += x;
            if(r + 1 < nums.length ) a[r + 1] -= x; 
        }

        int cumSum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            cumSum += a[i];
            a[i] = cumSum;

            if(nums[i] > a[i]) return false;
        }
        return true;
    }
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;

        boolean flag = true;
        
        for(int i = 0 ; i < n ; i++){
            if(nums[i] != 0){
                flag = false;
                break;
            }
        }

        if(flag) return 0;
        int l = 0 , r = q - 1 , ans = -1;
        while(l <= r){
            int mid = (l + r) / 2;

            if(helper(nums , queries , mid) == true){
                r = mid - 1;
                ans = mid + 1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }
}

/*class Solution {

    private boolean helper(int nums[] , int[][] queries , int k){
        int a[] = new int[nums.length];

        for(int i = 0 ; i <= k ; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            int x = queries[i][2];

            a[l] += x;
            if(r + 1 < nums.length ) a[r + 1] -= x; 
        }

        int cumSum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            cumSum += a[i];
            a[i] = cumSum;

            if(nums[i] > a[i]) return false;
        }
        return true;
    }
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;

        boolean flag = true;
        
        for(int i = 0 ; i < n ; i++){
            if(nums[i] != 0){
                flag = false;
                break;
            }
        }

        if(flag) return 0;

        for(int i = 0 ; i < q ; i++){
            if(helper(nums, queries , i) == true) return i + 1;
        }
        return -1;
    }
} */