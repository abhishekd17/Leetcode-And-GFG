class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        // int vis[][] = new int[n][m];
        Queue<Pair> q = new LinkedList();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    // vis[i][j] = 2;
                }
            }
        }
        int tm = 0;
        int[] drow = { -1, 0, 1, 0 };
        int[] dcol = { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int ii = pair.i;
            int jj = pair.j;
            int tt = pair.t;
            tm = Math.max(tm, tt);
            for (int i = 0; i < 4; i++) {
                int nrow = ii + drow[i];
                int ncol = jj + dcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1) {
                    q.add(new Pair(nrow, ncol, tt + 1));
                    grid[nrow][ncol] = 2;
                }
            }

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }

        return tm;
    }
}

class Pair {
    int i;
    int j;
    int t;

    Pair(int i, int j, int t) {
        this.i = i;
        this.j = j;
        this.t = t;
    }
}

/*class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        Queue<int[]> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j,0});
                    vis[i][j]=2;
                }
            }
        }

        int tm=0;
        int drow[]={-1,0,1,0};
        int dcol[]={0,1,0,-1};

        while(!q.isEmpty()){
            int cell[]=q.poll();
            int r=cell[0];
            int c=cell[1];
            int t=cell[2];
            tm=Math.max(tm,t);

            for(int i=0;i<4;i++){
                int nrow=r+drow[i];
                int ncol=c+dcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]!=2 && grid[nrow][ncol]==1){
                    q.add(new int[]{nrow,ncol,t+1});
                    vis[nrow][ncol]=2;
                }
            }

        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]!=2) return -1;
            }
        }
        return tm;
    }


} */