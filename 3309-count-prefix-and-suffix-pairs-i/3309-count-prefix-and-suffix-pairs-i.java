class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int ans = 0;
        // Arrays.sort(words, Comparator.reverseOrder());
        for(int i = 0 ;i < n; i++){
            String s1 = words[i];
            for(int j = i + 1 ; j < n ; j++){
                String s2 = words[j];
                if(isPrefAndSuff(s1, s2)){
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean isPrefAndSuff(String s1 , String s2){
        return s2.startsWith(s1) && s2.endsWith(s1) ;
    }
}