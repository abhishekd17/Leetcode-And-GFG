class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        int drow[] = {-1 , 0 , 1 , 0};
        int dcol[] = {0 , 1 , 0 , -1};

        boolean vis[][] = new boolean[n][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] - b[0]));

       pq.offer(new int[]{grid[0][0],0,0});

        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int s = temp[0];
            int i = temp[1];
            int j = temp[2];
            if(i == n - 1 && j == n - 1) return s;
            vis[i][j] = true;
            for(int k = 0 ; k < 4 ; k++){
                int nrow = i + drow[k];
                int ncol = j + dcol[k];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && !vis[nrow][ncol]){
                    int S = Math.max(s , grid[nrow][ncol]);
                    pq.offer(new int[]{S , nrow , ncol});
                    vis[nrow][ncol] = true;
                }
            }
        }
        return -1;
    }
}