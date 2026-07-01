class Solution {
    private void bfs(List<List<Integer>> grid , int score[][]  , int n){
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid.get(i).get(j) == 1){
                    score[i][j] = 0;
                    q.offer(new int[]{i , j});
                }
            }
        }
        int drow[] = {-1 , 0 , 1 , 0};
        int dcol[] = {0 , 1 , 0 , -1};
        while(!q.isEmpty()){
            int[] temp = q.poll();
            int i = temp[0];
            int j = temp[1];
            int s = score[i][j];

            for(int k = 0 ; k < 4 ;k++ ){
                int nrow = i + drow[k];
                int ncol = j + dcol[k];

                if(nrow >=0 && nrow < n && ncol >= 0 && ncol < n && score[nrow][ncol] > 1 + s){
                    score[nrow][ncol] = 1 + s;
                    q.offer(new int[]{nrow , ncol});
                }
            }
        }
    }
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if(grid.get(0).get(0) == 1 || grid.get(n-1).get(n-1) == 1) return 0;

        int score[][] = new int[n][n];
        for(int[] row : score) Arrays.fill(row , Integer.MAX_VALUE);
        bfs(grid , score , n);

        boolean vis[][] = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (b[0] - a[0]));
        pq.offer(new int[]{score[0][0] , 0 , 0});

        int drow[] = {-1 , 0 , 1 , 0};
        int dcol[] = {0 , 1 , 0 , -1};
        while(!pq.isEmpty()){
            int [] temp = pq.poll();
            int safe = temp[0];
            int i = temp[1];
            int j = temp[2];

            if(i == n - 1 && j == n - 1) return safe;
            vis[i][j] = true;

            for(int k = 0 ; k < 4 ;k++){
                int nrow = i + drow[k];
                int ncol = j + dcol[k];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && !vis[nrow][ncol]){
                    int s = Math.min(safe , score[nrow][ncol]);
                    pq.offer(new int[]{s , nrow , ncol});
                    vis[nrow][ncol] = true;
                }
            }
        } 
        return -1;
    }
}

