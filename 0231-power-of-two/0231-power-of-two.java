/*public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0 ) return false;
        if(n==536870912) return true;
        return Math.floor(Math.log(n) / Math.log(2)) == Math.ceil(Math.log(n) / Math.log(2));
    }
}
*/
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        int cnt = Integer.bitCount(n);
        return cnt == 1;
    }
}

/*class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false; // Negative numbers and zero are not powers of two
        return (n & (n - 1)) == 0;
    }
}
 */