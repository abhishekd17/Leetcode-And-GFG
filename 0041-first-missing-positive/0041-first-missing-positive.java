class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int maxi = 0;
        
        for(int x : nums){
            set.add(x);
            maxi = Math.max(maxi , x);
        } 
        
        for(int i = 1 ; i < maxi ; i++){
            if(!set.contains(i)) return i;
        }
        
        return maxi + 1;
    }
}