class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        
        int maxi = 0;
        for(int x : nums) maxi |= x;
        
        Map<String ,  Integer> dp = new HashMap<>();
        
        return helper(nums , 0 , 0 , maxi , dp);
    }

    private int helper(int nums[] , int ind , int currOr , int maxi , Map<String ,  Integer> dp){
        if(ind == nums.length){
            return maxi == currOr ? 1 : 0; 
        }
        
        String key = ind + "$" + currOr;
        if(dp.containsKey(key)) return dp.get(key);
        
        int np = helper(nums , ind + 1 , currOr , maxi , dp);
        int p = helper(nums , ind + 1 , currOr | nums[ind] , maxi , dp);
        
        int res = p + np;
        dp.put(key , res);
        
        return res;
    }
}