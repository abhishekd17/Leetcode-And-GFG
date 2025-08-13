class Solution {
    public boolean isPowerOfThree(int n) {
        int cnt = 0 , original = n; 
        while(n != 1 && n > 0){
            cnt++;
            n = n / 3;
        }

        for(int i = 0 ; i <= cnt ; i++){
            if((int) Math.pow(3 , i) == original) return true;
        }
        return false;
    }
}