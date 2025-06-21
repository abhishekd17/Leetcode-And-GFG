class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        pq.offer(new int[]{0 , 0 , grid[0][0]});

        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};
        boolean vis[][] = new boolean[n][n];

        while(!pq.isEmpty()){
            int top[] = pq.poll();
            int i = top[0];
            int j = top[1];
            int time = top[2];
            vis[i][j] = true;

            if(i == n - 1 && j == n - 1 ) return time;

            for(int k = 0 ; k < 4 ; k++){
                int r = i + drow[k];
                int c = j + dcol[k];

                if(r < 0 || c < 0 || r >= n || c >= n || vis[r][c]) continue;
                if(time >= grid[r][c]){
                    pq.offer(new int[]{r , c , time});
                    vis[r][c] = true;
                }else{
                    pq.offer(new int[]{r , c , grid[r][c]});
                    vis[r][c] = true;
                }
            }
        }
        return -1;
    }
}


/*class DisjointSet{
    int parent[];
    int rank[];
    int size[];
    public DisjointSet(int n ){
        this.parent = new int[n];
        this.rank = new int[n];
        this.size =new int[n];
        
        for(int i = 0 ; i < n ; i++){
            rank[i] = 0;
            size[i] = 1;
            parent[i] = i;
        }
    }
    int findParent(int node){
        if(node == parent[node]) return node;
        return parent[node] = findParent(parent[node]);
    }
    
    void unionByRank(int u , int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        
        if(ulp_u == ulp_v) return;
        if(rank[ulp_u] > rank[ulp_v]){
            parent[ulp_v] = ulp_u;
        }else if(rank[ulp_u] < rank[ulp_v]){
            parent[ulp_u] = ulp_v;
        }else{
            parent[ulp_u] = ulp_v;
            rank[ulp_v]++;
        }
    }
    
    void unionBySize(int u , int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        
        if(ulp_u == ulp_v) return ;
        
        if(size[ulp_u] > size[ulp_v]){
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }else{
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        }
    }
    
}
class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        DisjointSet ds = new DisjointSet(n * n);

        int vis[][] = new int[n][n];
        int locations[][] = new int[n * n][2];
        for(int i = 0 ; i  < n ; i++){
            for(int j = 0 ; j < n ; j++){
                locations[grid[i][j]] = new int[]{i,j};
            }
        }
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};

        for(int time = 0 ; time < n * n ; time++){
            int x = locations[time][0];
            int y = locations[time][1];
            vis[x][y] = 1;
            for(int k = 0 ; k < 4 ; k++){
                int newRow = x + drow[k];
                int newCol = y + dcol[k];
                if(isInBounds(newRow , newCol , n) && vis[newRow][newCol] == 1){
                    ds.unionBySize(x * n + y , newRow * n + newCol); 
                }
            }
            if(ds.findParent(0) == ds.findParent(n * n - 1)){
                return time;
            }
        }
        return n * n - 1;
    }
    private boolean isInBounds(int row , int col , int n){
        return row >= 0 && row < n && col >=0 && col < n;
    }
}
*/


















/*class Solution {
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
} */