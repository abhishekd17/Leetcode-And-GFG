class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] flip = new int[n]; // To track flips
        int f = 0; // Current number of flips
        int ans = 0; // Count of flips

        for (int i = 0; i <= n - k; i++) {
            // Update the current flip count based on previous flips
            if (i - k >= 0) {
                f -= flip[i - k]; // Remove the effect of the flip that ends at i - k
            }

            // Determine the effective value of nums[i] after considering flips
            if ((nums[i] + f) % 2 == 0) { // If the effective value is 0
                ans++; // We need to flip
                f++; // Increment the flip count
                flip[i] = 1; // Mark the start of a flip
            }
        }

        // Check the last k elements
        for (int i = n - k + 1; i < n; i++) {
            if (i - k >= 0) {
                f -= flip[i - k]; // Remove the effect of the flip that ends at i - k
            }
            // If the effective value is 0, we cannot flip
            if ((nums[i] + f) % 2 == 0) {
                return -1; // Not enough bits to flip
            }
        }

        return ans; // Return the total number of flips
    }
}

// brute force approch
/*class Solution {
    public int minKBitFlips(int[] nums, int p) {
        int n = nums.length;
        int ans = 0;
        
        for(int i = 0 ; i <= n - p ; i++){
            if(nums[i] == 0){
                for(int j = i ; j < i + p ; j++){
                    
                    nums[j] ^= 1;
                }
                ans++;
            }
            System.out.println(ans);
        }

        boolean flag = true;

        for(int i = n - 1 ; i >= 0 ; i--){
            if(nums[i] == 0) {
                flag = false;
                break;
            }
        }
        return flag == true ? ans : -1;
    }
}

 */