class Solution {
    public int trapRainWater(int[][] nums) {
        int n = nums.length;
        int m =  nums[0].length;

        int drow[] = {-1 , 0 , 1 , 0};
        int dcol[] = {0 , 1 , 0 , -1};

        int vis[][] = new int[n][m];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0] , b[0]));

        for(int i = 0 ; i < m ; i++){
            pq.offer(new int[]{nums[0][i] , 0 , i});
            pq.offer(new int[]{nums[n - 1][i] , (n -1 ) , i});
        }

        for(int i = 1 ; i < n - 1;  i++){
            pq.offer(new int[]{nums[i][0] , i , 0});
            pq.offer(new int[]{nums[i][m - 1] , i , (m -1)});
        }
        int water = 0;
        while(!pq.isEmpty()){
            int height = pq.peek()[0];
            int r = pq.peek()[1];
            int c = pq.peek()[2];
            pq.poll();

            vis[r][c] = 1;
            
            for(int i = 0 ; i < 4 ; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0){
                    vis[nrow][ncol] = 1;
                    water += Math.max(height - nums[nrow][ncol] , 0);
                    pq.offer(new int[]{Math.max(height, nums[nrow][ncol]) , nrow , ncol});
                }
            }
        }

        return water;
    }
}


// this will not give us correct answer
/*class Solution {
    public int trapRainWater(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;

        int left[][] = new int[n][m];
        int right[][] = new int[n][m];
        int up[][] = new int[n][m];
        int down[][] = new int[n][m];

        // left maxis
        for(int i = 0 ; i < n ; i++){
            left[i][0] = nums[i][0];
            for(int j = 1 ; j < m ; j++){
                left[i][j] = Math.max(left[i][j - 1] , nums[i][j]);
            }
        }

        // right maxis

        for(int i = 0 ; i < n ; i++){
            right[i][m - 1] = nums[i][m -1];
            for(int j = m - 2 ; j >=0 ; j--){
                right[i][j] = Math.max(right[i][j + 1] , nums[i][j]);
            }
        }

        // up maxi's

        for(int i = 0 ; i < m ; i++){
            up[0][i] = nums[0][i];
            for(int j = 1 ; j < n ; j++){
                up[j][i] = Math.max(up[j - 1][i] , nums[j][i]);
            }
        }
        // down maxis
        for(int i = 0 ; i < m ; i++){
            down[n - 1][i] = nums[n - 1][i];
            for(int j = n - 2 ; j >= 0 ; j--){
                down[j][i] = Math.max(down[j + 1][i] , nums[j][i]);
            }
        }

        
        int ans = 0;

        for(int i = 1 ; i < n - 1 ; i++){
            for(int j = 1 ; j < m - 1 ; j++){
                int mini = Math.min(Math.min(left[i][j -1] , right[i][j + 1]) , Math.min(up[i -1][j] , down[i + 1][j]));
                ans += Math.max(0 , (mini - nums[i][j]));
            }
        }
        return ans;
    }
} */