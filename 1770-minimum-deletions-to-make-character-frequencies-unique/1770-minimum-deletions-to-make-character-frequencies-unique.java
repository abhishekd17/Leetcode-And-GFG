class Solution {
    public int minDeletions(String s) {
        int freq[] = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }
        Arrays.sort(freq);
        int ans = 0;
        int used = freq[25];
        for(int i = 24 ; i >= 0 ; i--){
            if(freq[i] == 0) break;

            if(freq[i] >= used){
                int target = Math.max(0 , used - 1);
                ans += (freq[i] - target);
                used = target;
            }else{
                used = freq[i];
            }
        }
        return ans;
    }
}