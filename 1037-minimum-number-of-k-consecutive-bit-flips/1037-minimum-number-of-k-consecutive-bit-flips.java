class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int[] flip = new int[n + 1]; // To track the flips
        int currentFlips = 0; // Current number of flips affecting the current position

        for (int i = 0; i < n; i++) {
            currentFlips ^= flip[i]; // Update current flips based on previous flips

            // If the current bit is 0 after considering flips, we need to flip
            if ((nums[i] ^ currentFlips) == 0) {
                if (i + k > n) {
                    return -1; // Not enough bits to flip
                }
                ans++; // Increment the flip count
                currentFlips ^= 1; // We are flipping the current bit
                flip[i] ^= 1; // Mark the start of a flip
                if (i + k < n) {
                    flip[i + k] ^= 1; // Mark the end of a flip
                }
            }
        }
        return ans;
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