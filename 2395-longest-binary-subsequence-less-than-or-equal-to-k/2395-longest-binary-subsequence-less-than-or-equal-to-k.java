class Solution {
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        long val = 0;
        int cnt = 0;
        int power = 0;
        for(int i = n - 1 ; i >= 0 ; i--){
            char ch = s.charAt(i);
            if(ch == '0') cnt++;
            else{
                if(power < 32 && (val + (long) (1L << power)) <= k){
                    val += (1L << power);
                    cnt++;
                }
            }
            power++;
        }
        return cnt;
    }
}