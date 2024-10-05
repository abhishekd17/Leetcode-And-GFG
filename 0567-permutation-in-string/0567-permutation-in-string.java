class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        int freq1[] = new int[26];
        for(int  i = 0 ; i < n1 ; i++){
            freq1[s1.charAt(i) - 'a']++;
        }
        int freq2[] = new int[26];

        for(int i = 0 ; i < n2 ; i++){
            freq2[s2.charAt(i) - 'a']++;
            if(i >= n1 ){
                freq2[s2.charAt(i - n1)-'a']--;
            }
            if(match(freq1 , freq2)){
               return true;
            }
        }
        return false;
    }
    private boolean match(int freq1[] , int freq2[]){
        for(int i = 0 ; i < 26 ;i++){
            if(freq1[i] != freq2[i]){
                return false;
            }
        }
        return true;
    }
}