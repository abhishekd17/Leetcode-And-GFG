class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int n = grid.length , m = grid[0].length , q = queries.length;

        int ans[] = new int[q];
        int query[][] = new int[q][2];

        for(int i = 0 ; i < q ; i++){
            query[i][0] = queries[i];
            query[i][1] = i;
        }

        Arrays.sort(query, (a, b) -> a[0] - b[0]);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)  -> a.x - b.x);
        pq.offer(new Pair(0 , 0 , grid[0][0]));

        int score = 0;

        int drow[] = {-1 , 0 , 1 , 0};
        int dcol[] = {0 , 1 , 0 , -1};

        boolean vis[][] = new boolean[n][m];
        vis[0][0] = true;
        
        for(int i = 0 ; i < q ; i++){
            int x = query[i][0];
            while(!pq.isEmpty() && pq.peek().x < x){
                Pair pair = pq.poll();
                int row = pair.i;
                int col = pair.j;
                score++;

                for(int k = 0 ; k < 4 ; k++){
                    int nrow = row + drow[k];
                    int ncol = col + dcol[k];
                    if(nrow >=0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol]){
                        vis[nrow][ncol] = true;
                        pq.offer(new Pair(nrow , ncol , grid[nrow][ncol]));
                    }
                }
            }
            ans[query[i][1]] = score;
        }
        return ans;
    }
}

class Pair{
    int i;
    int j;
    int x;
    Pair(int i , int j , int x){
        this.i = i;
        this.j = j;
        this.x = x;
    }
}


/*class Solution {
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int[] maxPoints(int[][] grid, int[] queries) {
        int n = grid.length , m = grid[0].length , q = queries.length;
        int ans[] = new int[q];

        for(int i = 0 ; i < q ; i++){
            int vis[][] = new int[n][m];
            if(grid[0][0] > queries[i]){
                ans[i] = 0;
                continue;
            }
            ans[i] = dfs(grid , vis , 0 , 0 , queries[i]);
        }
        return ans;
    }

    private int dfs(int grid[][] , int vis[][] , int i , int j , int val){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || vis[i][j] == 1 || grid[i][j] >= val) return 0;
        vis[i][j] = 1;
        int cnt = 1;
        for(int dir[] : dirs){
            cnt += dfs(grid , vis , i + dir[0] , j + dir[1] , val);
        }
        return cnt;
    }
} */