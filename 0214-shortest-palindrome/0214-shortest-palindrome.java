class Solution {
    public String shortestPalindrome(String s) {
        // int i = 0, end = s.length() - 1, j = end;
        // char chs[] = s.toCharArray();
        // while (i < j) {
        //     if (chs[i] == chs[j]) {
        //         i++;
        //         j--;
        //     } else {
        //         i = 0;
        //         end--;
        //         j = end;
        //     }
        // }
        // return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;

        String temp = s + "#" + new StringBuilder(s).reverse().toString();
        int z[] = computeLPS(temp);
        return new StringBuilder(s.substring(z[z.length - 1])).reverse().toString() + s;
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