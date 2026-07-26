/*class Solution {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;


        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2) {
                max3 = max2;
                max2 = nums[i];
            } else if (nums[i] > max3) {
                max3 = nums[i];
            }
            if(nums[i]<min1){
                min2=min1;
                min1=nums[i];
            }
            if(nums[i]<min2){
                min2=nums[i];
            }
        }

        return Math.max(max1 * max2 * max3,max1*min1*min2);
    }
}*/
/*class Solution {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}*/
// import java.util.Arrays;


class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // Case 1: The maximum product is the product of the last three elements
        int maxProduct1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        // Case 2: The maximum product is the product of the two smallest negative numbers and the largest positive number
        int maxProduct2 = nums[0] * nums[1] * nums[n - 1];
        return Math.max(maxProduct1, maxProduct2);
    }
}

