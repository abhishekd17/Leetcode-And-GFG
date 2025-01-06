class Solution {
    public String longestPrefix(String s) {
        int lps[] = computeLPS(s);
        int len = lps[lps.length - 1];
        return s.substring(0 , len);
    }
    public static int[] computeLPS(String pattern){
        int m = pattern.length();
        int lps[] = new int[m];
        int len = 0;
        int i = 1 ;

        while(i  < m ){
            if(pattern.charAt(i) == pattern.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len != 0){
                    len = lps[len - 1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}