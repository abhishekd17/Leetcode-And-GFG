class Solution {
    public int hammingDistance(int x, int y) {
        int num = x ^ y;
        // return Integer.bitCount(num);
        int cnt = 0;
        for(int i = 0 ; i < 32 ; i++){
            cnt += (num >> i) & 1;
        }
        return cnt;
    }
}