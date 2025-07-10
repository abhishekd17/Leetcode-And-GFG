class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for(int i = 0 ; i < n ; i++){
            boolean vis[] = new boolean[n];
            for(int j = i ; ;){
                if(vis[j]) return true;
                vis[j] = true;
                if(nums[j] > 0){
                    int x = (j + nums[j]) % n;
                    if(j == x || nums[x] < 0) break;
                    j  = x;
                }
                else{
                    int x = ((j + nums[j]) % n + n) % n;
                    if(j == x || nums[x] > 0) break;
                    j = x;
                }
            }
        }
        return false;
    }
}