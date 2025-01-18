class Solution {
    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0 , 0 , 0});

        int res[][] = new int[n][m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j  < m ; j++){
                res[i][j] = Integer.MAX_VALUE;
            }
        }
        res[0][0] = 0;
        
        int drow[] = {0 , 0, 1 , -1};
        int dcol[] = {1 , -1 , 0 , 0};

        while(!pq.isEmpty()){
            int cost = pq.peek()[0];
            int i = pq.peek()[1];
            int j = pq.peek()[2];
            pq.poll();
            if(cost > res[i][j]) continue;

            for(int k = 0 ; k < 4 ; k++){
                int nrow = i + drow[k];
                int ncol = j + dcol[k];

                if(nrow >=0 && nrow < n && ncol >= 0 && ncol < m){
                    int newCost = cost + ((grid[i][j] - 1 != k) ?  1 : 0);
                    if(newCost < res[nrow][ncol]){
                        res[nrow][ncol] = newCost;
                        pq.offer(new int[]{newCost , nrow , ncol});
                    }
                }
            }
        }

        return res[n - 1][m - 1];
    }
}

/*class Solution {
    private int n ;
    private int m ;
    public int minCost(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        int vis[][] = new int[n][m];

        return dfs(0 , 0 , grid, vis , 0);
    }

    private int dfs(int r , int c , int[][] grid , int[][] vis , int cost ){
        
        // if reached at destination
        if(r == n - 1 && c == m - 1){
            return cost;
        }
        vis[r][c] = 1;

        int drow[] = {0 , 0, 1 , -1};
        int dcol[] = {1 , -1 , 0 , 0};
        int minCost = Integer.MAX_VALUE;
        for(int i = 0 ; i < 4 ; i++){
            int nrow = r + drow[i];
            int ncol = c + dcol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0){
                int nextCost = cost + ((grid[r][c] - 1 != i) ? 1 : 0);
                minCost = Math.min(minCost , dfs(nrow , ncol , grid , vis , nextCost));
            }
        }
        vis[r][c] = 0;

        return minCost;
    }
} */