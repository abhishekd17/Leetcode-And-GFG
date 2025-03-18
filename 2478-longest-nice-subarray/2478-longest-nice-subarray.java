class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int i = 0 , j = 0;

        int mask = 0;
        int ans = 1;

        while(j < n ){
            while((mask & nums[j]) != 0){
                mask ^= nums[i];
                i++;
            }
            ans = Math.max(ans , j - i + 1);
            mask |= nums[j];
            j++;
        }
        return ans;
    }
}



// better approch
/*class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;

        int ans = 0;

        for(int i = 0 ; i < n ; i++){
            int mask = 0 ;
            for(int j = i ; j < n ; j++){
                if((mask & nums[j]) != 0) break;
                else{
                    ans = Math.max(ans , j - i + 1);
                    mask |= nums[j];
                }
            }
        }
        return ans;
    }
}*/

// brute force
/*class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;

        int ans = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < j < n ; j++){
                if(isNice(nums , i , j)){
                    ans = Math.max(ans , j - i + 1);
                }else{
                    break;
                }
            }
        }
        return ans;
    }

    private boolean isNice(int nums[] , int i , int j){
        int mask = 0;
        for(int k = i ; k <= j ; k++){
            if((mask & nums[k]) != 0) return false;
            mask = mask | nums[k];
        }
        return true;
    }
} */