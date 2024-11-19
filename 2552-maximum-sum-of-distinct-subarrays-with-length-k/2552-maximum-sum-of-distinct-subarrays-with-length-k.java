class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int i = 0, j = 0;
        long ans = 0;
        long sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            sum += nums[j];
            if (j + 1 - i > k) {
                int x = nums[i];
                sum -= x;
                map.put(x, map.get(x) - 1);
                if (map.get(x) == 0) {
                    map.remove(x);
                }

                i++;
            }
            if (j + 1 - i== k && map.size() == k) {
                ans = Math.max(ans, sum);
            }
            j++;
        }
        return ans;
    }
}