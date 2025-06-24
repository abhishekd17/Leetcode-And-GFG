class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int n = nums.size();
        TreeSet<Integer> set = new TreeSet<>();
        int ans = Integer.MAX_VALUE;
        for(int i = x ; i < n ; i++){
            set.add(nums.get(i - x));
            Integer ceil = set.ceiling(nums.get(i));
            Integer floor = set.floor(nums.get(i));
            if(ceil != null) ans = Math.min(ans , Math.abs(nums.get(i) - ceil));
            if(floor != null) ans = Math.min(ans , Math.abs(nums.get(i) - floor));
        }
        return ans;
    }
}