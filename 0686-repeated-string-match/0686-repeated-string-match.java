class Solution {
    private static final int BASE = 31;
    public int repeatedStringMatch(String a, String b) {
        if(a.equals(b)) return 1;
        int cnt = 1;
        String ss= a;
        while(ss.length() < b.length()){
            cnt++;
            ss += a;
        }
        if(ss.equals(b)) return cnt;
        if(rabinKarp(ss , b) != -1) return cnt;
        if(rabinKarp(ss + a , b) != -1) return cnt + 1;
        return -1;
    }

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
}

// class Solution {
//     public int repeatedStringMatch(String a, String b) {
//         int cnt = 1;
//         String s = a;
//         while (a.length() < b.length()) {
//             cnt++;
//             a += s;
//         }
//         if(a.contains(b)) return cnt;
//         a += s;
//         if(a.contains(b)) return ++cnt;
//         return -1;
//     }
// }
/*class Solution {
    public int repeatedStringMatch(String a, String b) {
        int cnt = 1;
        String s = a;
        while (!a.contains(b)) {
            if (a.length() >= Math.pow(10,4)) { 
                return -1; 
            }
            cnt++;
            a += s;
        }

        return cnt;
    }
} */