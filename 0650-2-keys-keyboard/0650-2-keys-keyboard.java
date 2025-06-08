class Solution {
    public int minSteps(int n) {
        int ans = 0;
        while(n % 2 == 0){
            ans += 2;
            n /= 2;
        }
        for(int i = 3 ; i <= Math.sqrt(n) ; i++){
            while(n % i == 0){
                ans += i;
                n /= i;
            }
        }
        if(n > 2) ans += n;
        return ans;
    }
}