class Solution {
    public int minimizedMaximum(int n, int[] nums) {
        int maxi = Arrays.stream(nums).max().getAsInt();

        int l = 1; 
        int r = maxi ;
        while(l <= r){
            int mid = l + ( r - l ) / 2;
            int number = helper(nums , mid);
            if(number > n ) l = mid + 1;
            else r = mid -1;
        }
        return l;
    }
    private int helper(int nums[] , int n){
        int total = 0;
        for(int i = 0; i < nums.length ; i++){
            if(n != 0){
                total += (nums[i] + n - 1) / n ;
            }
        }
        return total;
    }
}