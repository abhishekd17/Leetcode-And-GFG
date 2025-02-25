class Solution {
    public int numOfSubarrays(int[] arr) {

        int ans = 0 , curr = 0, cnt[] = {1 , 0} , mod = (int)1e9 + 7;
        
        for(int a : arr){
            curr ^= a & 1;
            ans = (ans + cnt[1 - curr]) % mod;
            cnt[curr]++;
        }
        return ans;
    }
}