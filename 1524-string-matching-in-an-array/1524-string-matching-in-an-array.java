class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        Arrays.sort(words, Collections.reverseOrder());
        // System.out.println(words[0]);
        for(int i = 0 ; i < n ; i++){
            String s = words[i];
            for(int j = 0 ; j < n ; j++){
                if(i != j && KMP(words[i] , words[j])){
                    if(!ans.contains(words[j])){
                        ans.add(words[j]);
                    }
                }
            }
        }
        return ans;
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

    private static boolean KMP(String text , String pattern){
        int n = text.length();
        int m = pattern.length();
        if(pattern.isEmpty()) return true;
        int lps[] = computeLPS(pattern);

        int i = 0 , j  = 0;

        while(i < n){
            if(text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }
            if(j == m){
                return true;
            }else if(i < n  && text.charAt(i) != pattern.charAt(j)){
                if(j != 0){
                    j = lps[j - 1];
                }else{
                    i++;
                }
            }
        }
        return false;
    }
}