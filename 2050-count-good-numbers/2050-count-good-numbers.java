class Solution {
    private int mod = (int) 1e9 + 7;
    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2;
        long odd = n / 2;

        long ans = pow(5 , even) % mod * pow(4 , odd) % mod;
        return (int)ans;
    }
    private long pow(long base , long exp){
        long ans = 1;
        while(exp > 0){
            if(exp % 2 == 1){
                ans = (ans * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return ans;
    }
}


/*class Solution {
    private int mod = (int)1e9 + 7;
    public int countGoodNumbers(long n) {
        int cnt = 0;
        long nn = (long) Math.pow(10 , n) - 1;
        for(long i = 1 ; i <= nn ; i++){
            String s = String.valueOf(i);
            if(evenInd(s) && primeOdd(s)) cnt = (cnt + 1) % mod;
        }
        return cnt % mod;
    }

    private boolean evenInd(String s){
        boolean isEvenInd = true;
        for(int i = 0 ; i < s.length() ; i += 2){
            if((s.charAt(i) - '0') % 2 != 0) return false;
        }
        return true;
    }

    private boolean primeOdd(String s){
        boolean prime = true;
        for(int i = 1 ; i < s.length() ; i += 2){
            if(!isPrime(s.charAt(i) - '0')) return false;
        }
        return true;
    }

    private boolean isPrime(int n){
        if(n == 2 || n == 3 || n == 5 || n == 7) return true;
        return false;
    }
} */