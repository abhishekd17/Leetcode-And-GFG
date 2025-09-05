class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for(int i = 1 ; i <= 60 ; i++){
            long val = num1 - (long)i * num2;
            if (val < i) continue; 
            int bits = Long.bitCount(val);
            // System.out.println(val + " " + bits);
            if(bits <= i && bits <= val) return i;
        }
        return -1;
    }
}

// 110  55
// i == 1  110 - 55 --> 5
// i == 2  110 - 110 --> 0

