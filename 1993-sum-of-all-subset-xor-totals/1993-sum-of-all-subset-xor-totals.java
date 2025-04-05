class Solution {
    public int subsetXORSum(int[] nums) {
        int ans = 0;
        
        for(int num : nums){
            ans |= num;
        }
        return ans << nums.length - 1;
    }
}


/*class Solution {
    public int subsetXORSum(int[] nums) {
        return helper(nums , 0 , 0);
    }
    private int helper(int nums[] , int ind , int xor){
        if(ind == nums.length) return xor;
        int include = helper(nums , ind + 1 , xor ^ nums[ind]);
        int exclude = helper(nums , ind + 1 , xor);
        return include + exclude;
    }
}*/

/*class Solution {
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
       
        List<List<Integer>> result = new ArrayList<>();
        helper2(nums , 0 , new ArrayList<>() , result);
        
        int ans = 0;
        
        for(List<Integer> sub: result){
            int xor = 0;
            for(int x : sub){
                xor ^= x;
            }
            ans += xor;
        }
        return ans;
    }
    private void helper(int nums[] , int ind , List<Integer> curr , List<List<Integer>> result){
        if(ind == nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }

        // include
        curr.add(nums[ind]);
        helper(nums , ind + 1, curr , result);

        curr.remove(curr.size() - 1);
        helper(nums , ind + 1 , curr , result);
    }

    private void helper2(int nums[] , int start , List<Integer> curr , List<List<Integer>> result){
        result.add(new ArrayList<>(curr));
        for(int i = start ; i < nums.length ; i++){
            curr.add(nums[i]);
            helper2(nums , i + 1 , curr , result);
            curr.remove(curr.size() - 1);
        }
    }

    
} */