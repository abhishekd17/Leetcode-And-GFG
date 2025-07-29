class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        
        int setBitIndex[] = new int[32];
        Arrays.fill(setBitIndex , -1);

        for(int i = n - 1 ; i >= 0 ; i--){
            int endIndex = i;
            
            for(int j = 0 ; j < 32 ; j++){
                if((nums[i] & (1 << j)) == 0){  // if bit 
                    if(setBitIndex[j] != -1){
                        endIndex = Math.max(endIndex , setBitIndex[j]);
                    }
                }else{
                    setBitIndex[j] = i;
                }
            }
            ans[i] = endIndex - i + 1;
        }
        return ans;
    }
}

/*class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        
        int maxOr = 0;
        for(int i = 0 ; i < n ; i++) maxOr |= nums[i];

        for(int i = 0 ; i < n ; i++){
            int x = 0;
            int maxi = Integer.MIN_VALUE;
            int len = 0;
            for(int j = i ; j < n ;j++){
                x |= nums[j];
                if(x > maxi){
                    maxi = x;
                    len = j - i + 1;
                }
                if(x == maxOr) break;
            }
            ans[i] = len;
        }
        return ans;
    }
} */