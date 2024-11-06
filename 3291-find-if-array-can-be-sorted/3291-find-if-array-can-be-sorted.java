class Solution {
    public boolean canSortArray(int[] nums) {
        int pmax = 0 , cmin = 0 , cmax = 0;
        byte pcnt = 0;

        for(int num :nums){
            final byte ccnt = (byte)Integer.bitCount(num);
            if(ccnt == pcnt){
                cmin = cmin > num ? (short) num : cmin;
                cmax = cmax < num ? (short) num : cmax;
            }else if(cmin < pmax) return false;
            else{
                pmax = cmax ;
                cmin = cmax = (short) num;
                pcnt = ccnt;
            }
        }
        return cmin >= pmax;
    }
}