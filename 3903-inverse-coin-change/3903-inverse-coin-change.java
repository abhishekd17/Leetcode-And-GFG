class Solution {
    public List<Integer> findCoins(int[] nums) {
        int n = nums.length;
        long ways[] = new long[n + 1];
        List<Integer> ans = new ArrayList<>();
        ways[0] = 1;
        for(int i = 1 ; i <= n ; i++){
            if(nums[i - 1] == ways[i] ) continue;
            else if(nums[i - 1] - ways[i] == 1){
                ans.add(i);
                for(int j = i ; j <= n ; j++){
                    ways[j] += ways[j - i];
                }
            }else{
                return Collections.emptyList();
            }
        } 
        return ans;
    }
}