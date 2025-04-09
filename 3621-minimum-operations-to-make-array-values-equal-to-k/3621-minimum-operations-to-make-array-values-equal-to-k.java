class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        
        Set<Integer> set = new HashSet<>();
        
        int mini = Integer.MAX_VALUE;
        
        for(int num : nums) {
            set.add(num);
            mini = Math.min(mini , num);
        }
        
        if(mini < k) return -1;
        
        if(mini == k) return set.size() - 1;
        
        return set.size();
    }
}