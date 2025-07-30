class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int x : nums) set.add(x);
        int maxi = 0;
        for(int i = 0 ; i < n ; i++) maxi = Math.max(maxi , nums[i]);
        for(int i = 1 ; i < maxi ; i++){
            if(!set.contains(i)) return i;
        }
        return maxi + 1;
    }
}