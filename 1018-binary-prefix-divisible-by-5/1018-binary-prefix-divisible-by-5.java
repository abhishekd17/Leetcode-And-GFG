class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int n = nums.length;
        List<Boolean> ans = new ArrayList<>();
        int x = 0;
        for(int bit : nums){
            x = (x * 2 + bit)  % 5;
            ans.add(x == 0);
        }
        return ans;
    }
}