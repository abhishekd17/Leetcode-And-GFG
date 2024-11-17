class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;

        int i = 0 , j = 0;
        int mul = 1;
        while(j < n ){
            mul *= nums[j];
            while(i <= j && mul >= k){
                mul = mul / nums[i];
                i++;
            }
            if(mul < k ){
                ans += (j - i + 1);
            }
            j++;
        }
        return ans;
    }
}