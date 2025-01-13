class Solution {
    public int minimumLength(String s) {
        int freq[] = new int[26];
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }

        int ans = 0;
        for(int i = 0 ; i < 26 ; i++){
            if(freq[i] > 2){
                if(freq[i] % 2 == 0) freq[i] = 2;
                else freq[i] = 1;
            }
            ans += freq[i];
        }
        return ans;
    }
}