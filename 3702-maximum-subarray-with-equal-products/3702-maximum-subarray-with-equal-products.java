class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int maxi = 0;
        for(int i = 0 ; i < n ; i++){
            int prod = 1;
            int GCD = nums[i];
            int LCM = nums[i];
            for(int j = i ; j < n ; j++){
                GCD = gcd(GCD , nums[j]);
                LCM = lcm(LCM , nums[j]);
                int x = LCM * GCD;
                prod *= nums[j];
                if(prod == x){
                    maxi = Math.max(maxi , j - i + 1);
                }
            }
        }
        return maxi;
    }
    private int gcd(int a , int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    private int lcm(int a , int b){
        return (a / gcd(a , b)) * b;
    }

}