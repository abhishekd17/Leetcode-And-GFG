class Solution {
    public boolean canArrange(int[] arr, int k) {
        int n = arr.length;
        int freq[] = new int[k + 1];

        for(int i = 0 ; i < n ;i++){
            freq[(arr[i] % k + k ) % k]++;
        }
        for(int i = 1 ; i <= k / 2; i++){
            if(freq[i] != freq[k - i]) return false;
        }
        return (freq[0] + freq[k]) % 2 == 0 ? true : false; 
    }
}