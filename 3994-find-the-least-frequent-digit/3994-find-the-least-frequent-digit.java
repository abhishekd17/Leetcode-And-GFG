class Solution {
    public int getLeastFrequentDigit(int n) {
        int freq[] = new int[10];
        
        while(n > 0){
            int digit = n % 10;
            freq[digit]++;
            n /= 10;
        }
        
        int ans = 0 , minFreq = Integer.MAX_VALUE;
        
        for(int i = 0 ; i < 10 ; i++){
            if(freq[i] != 0 && freq[i] < minFreq){
                ans = i;
                minFreq = freq[i];
            }
        }
        return ans;
    }
}