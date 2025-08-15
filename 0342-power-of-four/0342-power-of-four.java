class Solution {
    public boolean isPowerOfFour(int n) {
        int x = n & (n-1);
        return (x == 0) && (n % 3 == 1);
    }
}