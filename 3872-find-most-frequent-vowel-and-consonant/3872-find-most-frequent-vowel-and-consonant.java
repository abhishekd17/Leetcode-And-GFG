class Solution {
    public int maxFreqSum(String s) {
        int n = s.length();

        int freq[] = new int[26];

        for(int i = 0 ; i < n ; i++){
            freq[s.charAt(i) - 'a']++;
        }

        int maxVowel = 0 , maxCon = 0;
        for(int i = 0 ; i < 26 ; i++){
            if(i == 0 || i == 4 || i == 8 || i == 14 || i == 20){
                maxVowel = Math.max(maxVowel , freq[i]);
            }else{
                maxCon = Math.max(maxCon , freq[i]);
            }
        }

        return maxVowel + maxCon;
    }
}