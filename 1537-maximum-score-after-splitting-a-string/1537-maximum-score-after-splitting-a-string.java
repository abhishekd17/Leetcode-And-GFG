class Solution {
    public int maxScore(String s) {
        int n = s.length();

        int pref[] = new int[n + 1];
        int suff[] = new int[n + 1];

        for(int i = 0 ; i < n ; i++){
            pref[i + 1 ] = pref[i] + (s.charAt(i) == '0' ? 1 : 0);
            suff[n - i - 1] = suff[n - i] + (s.charAt(n - i - 1) == '1' ? 1 : 0);
        }
        
        if(pref[n] == n || suff[0] == n) return n-1;

        int ans = 0;
        for(int i = 1 ; i < n ; i++){
            ans = Math.max(suff[i] + pref[i] ,  ans);
        }
        return ans;
    }
}