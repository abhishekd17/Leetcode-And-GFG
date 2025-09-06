class Solution {
    public long minOperations(int[][] nums) {
        
        long ans = 0;

        for(int[] num : nums){
            
            int l = num[0] , r = num[1];
            
            long d = 0 , s = 1;
            
            int k = 1;
            
            while(s <= r){
                long e = s * 4 - 1;
                long lower = Math.max(l , (int) s);
                long higher = Math.min(r , (int) e);
                if(lower <= higher){
                    long cnt = higher - lower + 1;
                    d += (cnt * k);
                }
                k++;
                s *= 4;
            }
            ans += ((d + 1) / 2);
        }
        return ans;
    }
}