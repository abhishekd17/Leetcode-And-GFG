class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        int mini = Integer.MAX_VALUE;
        Arrays.sort(nums);
        if(n < 5) return 0;
        for(int i = 0 ; i < 4 ; i++){
            mini = Math.min(mini , nums[n - 4 + i] - nums[i]);
        }
        return mini;
    }
}

/*class Solution {
    public int minDifference(int[] a) {
        int n = a.length;
        if(n <= 4) return 0;
        Arrays.sort(a);
        int mini = a[n - 1] - a[0] ;
        mini = Math.min(a[n - 1] - a[1] , a[n - 2] - a[0]);
        mini = Math.min(a[n - 3] - a[0] , Math.min(a[n - 2] - a[1] , a[n - 1] - a[2]));
        mini = Math.min(Math.min(a[n - 4] - a[0] , a[n - 3] - a[1]) , Math.min(a[n -2 ] - a[2] , a[n -1 ] - a[3]));
        return mini;
    }
} */