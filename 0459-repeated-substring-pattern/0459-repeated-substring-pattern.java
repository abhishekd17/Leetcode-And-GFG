class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        
        // Iterate over possible substring lengths (from 1 to n / 2)
        for (int len = 1; len <= n / 2; len++) {
            // If n is not divisible by len, it can't be a repeated substring
            if (n % len == 0) {
                String substring = s.substring(0, len);
                
                // Using Rabin-Karp to check if repeating the substring creates the original string
                if (rabinKarp(s, substring)) {
                    return true;
                }
            }
        }
        
        return false;
    }

    private static final int BASE = 31;  // Base for Rabin-Karp hash calculation
    private static final int MOD = 1000000007;  // Large prime modulus to avoid overflow

    private static boolean rabinKarp(String s, String substring) {
        int n = s.length();
        int m = substring.length();
        
        if (m == 0 || n == 0 || n % m != 0) return false;
        
        // Compute the hash for the substring (target)
        long targetHash = 0;
        for (int i = 0; i < m; i++) {
            targetHash = (targetHash * BASE + substring.charAt(i)) % MOD;
        }

        // Sliding window over string `s` to check if repeating the substring matches `s`
        long windowHash = 0;
        for (int i = 0; i < m; i++) {
            windowHash = (windowHash * BASE + s.charAt(i)) % MOD;
        }

        // Check if the first window hash equals the target hash
        if (windowHash == targetHash) {
            boolean matches = true;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) != substring.charAt(i % m)) {
                    matches = false;
                    break;
                }
            }
            if (matches) return true;
        }

        return false;
    }
}


/*/*class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int  n = s.length();

        for(int l = n / 2 ;  l > 0 ; l--){
            if(n % l == 0){ // O(sqrt(n))
                int times = n / l ;
                String str = s.substring(0 , l); // O(n / 2)
                String x = "";
                while(times-- > 0){ // O(n / l)
                    x += str;
                } 
                if(x.equals(s)) return true;
            }
        }
        return false;
    }
}*/

// overall time complexity will be 
// O(sqrt(n) * (O(n / 2 ) + O(n / l)))
// O(sqrt(n) * O(n)) */