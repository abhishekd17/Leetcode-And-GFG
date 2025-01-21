class Solution {
    public long gridGame(int[][] grid) {
        long top = Arrays.stream(grid[0]).asLongStream().sum() , bottom = 0 , ans = Long.MAX_VALUE;
        for(int i = 0 ; i < grid[0].length ; i++){
            top -= grid[0][i];
            ans = Math.min(Math.max(top , bottom) , ans);
            bottom += grid[1][i];
        }
        return ans;
    }
}


/*class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;

        long ans = Long.MAX_VALUE;
        long pref1[] = new long[n];
        long pref2[] = new long[n];
        pref1[0] = grid[0][0];
        pref2[0] = grid[1][0];

        for(int i = 1 ; i < n ; i++){
            pref1[i] = pref1[i - 1] + grid[0][i];
        }
        for(int i = 1 ; i < n ; i++){
            pref2[i] = pref2[i - 1] + grid[1][i];
        }

        for(int i = 0 ; i < n ; i++){
            System.out.println(pref1[i] + " " + pref2[i]);
        }
        for(int i = 0 ; i < n ; i++){
            long first = pref1[n - 1] - pref1[i];
            if(i > 0 ) first = Math.max(pref2[i - 1] , first);
            ans = Math.min(first , ans);
        }
        return ans;
    }
} */