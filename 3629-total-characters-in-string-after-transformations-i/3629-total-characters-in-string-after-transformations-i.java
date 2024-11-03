class Solution {
    public int lengthAfterTransformations(String s, int t) {
        final int mod = 1000000007;
        long cnt[] = new long[26];

        for(char c : s.toCharArray()){
            cnt[c - 'a']++;
        }

        for(int j = 0 ; j < t ; j++){
            long tmp[] = new long[26];
            for(int i = 0; i < 26; i++){
                if(i == 25){
                    tmp[0] = (tmp[0] + cnt[i]) % mod;
                    tmp[1] = (tmp[1] + cnt[i]) % mod;
                }else{
                    tmp[i + 1] = (tmp[i + 1] + cnt[i]) % mod;
                }
            }
            cnt = tmp;
        }

        long len = 0;
        for(long c : cnt){
            len = (len + c ) % mod;
        }
        return (int) len;
    }
}

/*class Solution {
    public int lengthAfterTransformations(String s, int t) {
        
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0 ; i < t ; i++){
            int n = sb.length();
            for(int j = 0 ; j < n ; j++){

                if(sb.charAt(j) == 'z'){
                    sb.replace(j , j + 1 , "ab");
                    j++;
                    n++;
                }else{
                    sb.setCharAt(j, (char)((int)sb.charAt(j) + 1));
                }
            }
            // System.out.println(sb);
        }
        return sb.length() % 1000000007;
    }
} */