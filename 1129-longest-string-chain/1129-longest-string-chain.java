class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        int dp[] = new int[n];
        Arrays.fill(dp ,1);
        Arrays.sort(words , (a,b) -> a.length() - b.length());
        int maxi = 1;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j  < i ; j++){
                if(check(words[i] , words[j]) && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }
            if(dp[i] >  maxi){
                maxi = dp[i];
            }
        } 
         return maxi;   
    }
    private boolean check(String s , String t){
        if(s.length() != t.length() + 1) return false;
        int i = 0;
        int j = 0;

        while(i <  s.length()){
            if(j < t.length() && s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
        }

        if(i == s.length() && j == t.length()) return true;
        return false;
    }  
}