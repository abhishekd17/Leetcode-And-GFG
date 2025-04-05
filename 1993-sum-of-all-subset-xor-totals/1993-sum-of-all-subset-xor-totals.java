class Solution {
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
       
        List<List<Integer>> result = new ArrayList<>();
        helper(nums , 0 , new ArrayList<>() , result);
        
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
}