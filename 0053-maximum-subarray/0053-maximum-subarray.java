/*
public class Solution {
    public static int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length - 1);
    }
    
    private static int maxSubArray(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        
        int mid = left + (right - left) / 2;

        int maxLeftHalf = maxSubArray(nums, left, mid);
        int maxRightHalf = maxSubArray(nums, mid + 1, right);
        int maxAcrossMid = maxAcrossMid(nums, left, mid, right);
        
        return Math.max(Math.max(maxLeftHalf, maxRightHalf), maxAcrossMid);
    }
    
    private static int maxAcrossMid(int[] nums, int left, int mid, int right) {
        int maxLeftSum = Integer.MIN_VALUE;
        int maxRightSum = Integer.MIN_VALUE;
        
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            maxLeftSum = Math.max(maxLeftSum, sum);
        }
        
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            maxRightSum = Math.max(maxRightSum, sum);
        }
        
        return maxLeftSum + maxRightSum;
    }
}*/

class Solution {
    public int maxSubArray(int[] arr) {
        int maxSum = arr[0];
        int currSum = arr[0];
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            currSum = Math.max(arr[i], currSum + arr[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}

/*
 * class Solution {
 * public int maxSubArray(int[] nums) {
 * int maxi = Integer.MIN_VALUE;
 * int n = nums.length;
 * int sum = 0;
 * int ansStart=-1;
 * int ansEnd=-1;
 * 
 * for (int i = 0; i < n; i++) {
 * if(sum==0) ansStart=i;
 * sum += nums[i];
 * // maxi = Math.max(maxi, sum);
 * if(sum>maxi){
 * maxi=sum;
 * ansStart=ansStart;
 * ansEnd=i;
 * }
 * if (sum < 0) {
 * sum = 0;
 * }
 * }
 * 
 * return maxi;

 * }
 * }
 */

/*
 * class Solution {
 * public int maxSubArray(int[] nums) {
 * int maxi=Integer.MIN_VALUE;
 * int n=nums.length;
 * int sum=0;
 * for(int i=0;i<n;i++){
 * sum=0;
 * for(int j=i;j<n;j++){
 * sum+=nums[j];
 * maxi=Math.max(maxi,sum);
 * }
 * }
 * return maxi;
 * }
 * }
 */

/*
 * class Solution {
 * public int maxSubArray(int[] nums) {
 * int maxi = Integer.MIN_VALUE;
 * int n = nums.length;
 * for (int i = 0; i < n; i++) {
 * for (int j = i; j < n; j++) {
 * int sum = 0;
 * for (int k = i; k <= j; k++) {
 * sum += nums[k];
 * }
 * maxi = Math.max(maxi, sum);
 * }
 * }
 * return maxi;
 * }
 * }
 */