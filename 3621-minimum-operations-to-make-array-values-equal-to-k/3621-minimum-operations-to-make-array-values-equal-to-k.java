class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        
        Set<Integer> set = new HashSet<>();
        
        for(int num : nums) set.add(num);

        Arrays.sort(nums);
        
        if(nums[0] < k) return -1;
        
        if(nums[0] == k) return set.size() - 1;
        
        return set.size();
    }
}