class Solution {
    public int minimumDeletions(String word, int k) {
        int n = word.length();
        int freq[] = new int[26];

        for(int i = 0 ; i < n ; i++){
            freq[word.charAt(i) - 'a']++;
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < 26 ; i++){
            int mini = 0;
            for(int j = 0 ; j < 26 ; j++){
                if(i == j) continue;
                if(freq[j] < freq[i]) mini += freq[j];
                else if(freq[j] > freq[i] + k){
                    mini += Math.abs(freq[j] - freq[i] - k);
                }
            }
            ans = Math.min(ans , mini);
        }
        return ans;
    }
}