class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int prefixXor[] = new int[n];
        int ans[] = new int[n];
        prefixXor[0] = nums[0];
        for(int i = 1 ; i < n ; i++){
            prefixXor[i] = prefixXor[i - 1] ^ nums[i];
        }
        for(int i = 0 ;i < n ; i++){
            ans[i] = prefixXor[n - i - 1] ^ (int)(Math.pow(2, maximumBit) - 1);
        }
        return ans;
    }
}