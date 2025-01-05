/*class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if (n < m) {
            return -1;
        }

        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
                if (j == m) {
                    return i;
                }
            }
        }
        return -1;
    }
}
*/
/*
 * class Solution {
 * public int strStr(String haystack, String needle) {
 * int index=haystack.indexOf(needle);
 * return index;
 * }
 * }
 */


 class Solution {
    public int strStr(String haystack, String needle) {
        // return rabinKarp(haystack , needle);
        int[] z = calculateZ(needle + "$" + haystack);
        for(int i = 0 ; i < z.length ; i++){
            if(z[i] == needle.length()) return i - needle.length() - 1;
        }
        return -1;
    }
        private static final int BASE = 10000;

    private static int rabinKarp(String s, String t) {
        // first case
        if (s.isEmpty() || t.isEmpty()) return -1;

        int m = t.length();
        int power = 1;

        // compute power = (31^(m -1)) % base
        for (int i = 0; i < m; i++) {
            power = (int) ((long) power * 31) % BASE;
        }

        int targetCode = 0;
        int hashCode = 0;

        // compute hash codes for the target and the initial window in the source
        for (int i = 0; i < m; i++) {
            targetCode = (int) (((long) targetCode * 31 + t.charAt(i))) % BASE;
        }

        // sliding window over the source string
        for (int i = 0; i < s.length(); i++) {
            hashCode = (int) ((long) hashCode * 31 + s.charAt(i)) % BASE;
            if (i < m - 1) continue;
            if (i >= m) {
                // remove the influence of the outgoing char
                hashCode = (int) ((long) hashCode - (long) s.charAt(i - m) * power) % BASE;
            }
            if (hashCode < 0) hashCode += BASE;

            // now check if hashcode matches with target hash
            if (hashCode == targetCode) {
                if (s.substring(i - m + 1, i + 1).equals(t)) {
                    return i - m + 1;
                }
            }
        }
        return -1;
    }
    private static int[] calculateZ(String s){
        int n = s.length();
        int z[] = new int[n];
        int left = 0;
        int right = 0;
        for(int i = 0 ; i < n ; i++){
            if(i > right){
                left = right = i;
                while(right < n && s.charAt(right) == s.charAt(right - left)){
                    right++;
                }
                z[i] = right - left;
                right--;
            }else{
                // we are operating inside the box
                int k1 = i - left;
                // if value does not stretches till right bound then just copy it
                if(z[k1] < right - i + 1){
                    z[i] = z[k1];
                }else{ // try to see if there are more matches
                    left  = i;
                    while(right < n  && s.charAt(right) == s.charAt(right - left)){
                        right++;
                    }
                    z[i] = right - left;
                    right--;
                }
            }
        }
        return z;
    }
}