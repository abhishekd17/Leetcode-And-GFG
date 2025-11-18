class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int i = 0;
        while(i < n){
            if(i < n && bits[i] == 0) i++;
            else if(i < n && bits[i] == 1){
                i += 2;
                if(i >= n) return false;
            }
        }
        return true; 
    }
}

//  1 1 1 0
// i == 0
// i == 2
