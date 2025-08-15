class Solution {
    Map<String , Boolean> map = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (s1.equals(s2)) return true;
        if (n != m) return false;
        String key = s1 + "$" + s2;
        if(map.containsKey(key)) return map.get(key);
        boolean result = false;
        for (int i = 1; i < n; i++) {
            boolean swap = isScramble(s1.substring(i, n), s2.substring(0 , n - i )) && 
                           isScramble(s1.substring(0, i), s2.substring(n - i , n));
            boolean not_swap = isScramble(s1.substring(0, i), s2.substring(0, i)) && 
                               isScramble(s1.substring(i, n), s2.substring(i, n));

            if (swap || not_swap) {
                result = true;
                break;
            }
        }
        map.put(key , result);
        return result;
    }
}
