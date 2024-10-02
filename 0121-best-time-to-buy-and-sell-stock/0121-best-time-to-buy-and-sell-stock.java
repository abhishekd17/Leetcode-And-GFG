class Solution {
    public int maxProfit(int[] arr) {
        // int n = nums.length;
        // int maxPro = 0;
        // int maxi=0;
        // int minPrice = Integer.MAX_VALUE;
        // for (int i = 0; i < n; i++) {
        // if (nums[i] <minPrice) {
        // minPrice = nums[i];
        // }
        // maxPro = nums[i]-minPrice;
        // maxi = Math.max(maxPro, maxi);
        // }
        // return maxi;

        int maxPro = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            minPrice = Math.min(minPrice, arr[i]);
            maxPro = Math.max(maxPro, arr[i] - minPrice);
        }
        return maxPro;
    }
}

/*
 * class Solution {
 * public int maxProfit(int[] prices) {
 * int n = prices.length;
 * int maxi = 0;
 * int profit = 0;
 * 
 * for (int i = 0; i < n; i++) {
 * for (int j = i + 1; j < n; j++) {
 * if (prices[j] > prices[i]) {
 * profit = prices[j] - prices[i];
 * maxi = Math.max(maxi, profit);
 * }
 * }
 * }
 * return maxi;
 * }
 * }
 */