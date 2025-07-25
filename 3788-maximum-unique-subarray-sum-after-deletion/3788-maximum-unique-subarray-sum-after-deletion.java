class Solution {
    public int maxSum(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        boolean zero = false;
        boolean pos = false;
        for(int x : nums){
            if(x > 0) pos = true;
            if(x == 0) zero = true;
            if(x < 0){
                maxi = Math.max(maxi , x);
                continue;
            }
            if(!set.contains(x)){
                sum += x;
            }
            if(x > 0) set.add(x);
        }
        if(pos) return sum;
        else if(!pos && !zero) return maxi;
        else if(zero) return 0;
        return -1;
    }
}