class Solution {
    public int maximumLength(int[] nums) {
        int n = nums.length;
        int parity = nums[0] % 2 , even = 0 , odd = 0, both = 0;
        for(int num : nums){
            if(num % 2 == 0) even++;
            else odd++;
            if(num % 2 == parity){
                both++;
                parity = 1 - parity;
            }
        }
        return Math.max(both , Math.max(even , odd));
    }
}