class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if(n % 2 == 0 && m % 2 == 0 ) return 0;

        int xor1 = 0 , xor2 = 0;
        for(int i = 0 ; i < n  ; i++){
            xor1 ^= nums1[i];
        }

        for(int j = 0 ; j < m ; j++){
            xor2 ^= nums2[j];
        }

        if(n % 2 == 0 && m % 2 != 0 ) return xor1;
        if(n % 2 != 0 && m % 2 != 0) return xor1 ^ xor2;
        return xor2;
    }
}