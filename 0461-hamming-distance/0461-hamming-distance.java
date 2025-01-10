class Solution {
    public int hammingDistance(int x, int y) {
        int num = x ^ y;
        return Integer.bitCount(num);
    }
}