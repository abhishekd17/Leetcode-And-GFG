class Solution {
    private int mod = 1000000007;

    public int specialTriplets(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        for (int num : nums) {
            right.put(num, right.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            right.put(nums[i], right.get(nums[i]) - 1);
            if (right.get(nums[i]) == 0) {
                right.remove(nums[i]);
            }
            ans = (int)(ans +((long)left.getOrDefault(nums[i] * 2, 0) * right.getOrDefault(nums[i] * 2, 0)) % mod) % mod;
            left.put(nums[i], left.getOrDefault(nums[i], 0) + 1);
        }
        return ans % mod;
    }
}