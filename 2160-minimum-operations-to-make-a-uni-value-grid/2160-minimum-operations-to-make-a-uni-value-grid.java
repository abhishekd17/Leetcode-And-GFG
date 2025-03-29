class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;


        int nums[] = new int[n * m];
        int k = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                nums[k++] = grid[i][j];
            }
        }

        Arrays.sort(nums);

        int y = nums[0] % x;

        int nn = nums.length;
        
        for(int i = 1 ; i < nn; i++){
            if(y != (nums[i] % x)){
                return -1;
           }
        }
        int ans = 0;
        int xx = nums[nn / 2];
        for(int i = 0 ; i < nn ; i++){
            ans += (Math.abs(nums[i] - xx) / x);
        }  
        return ans;
    }
}