class Solution {
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        boolean vis[][][] = new boolean[n][m][k + 1];
        
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0 , 0 , k));
        grid[0][0] = 2;
        vis[0][0][k] = true;

        int drow[] = {-1 , 0 , 1 , 0};
        int dcol[] = {0 , 1 , 0 , -1};

        int steps = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                Pair p = q.poll();
                int i = p.row;
                int j = p.col;
                int rem = p.remK;

                if(i == n - 1 && j == m - 1) return steps;

                for(int d = 0 ; d < 4 ; d++){
                    int newRow = i + drow[d];
                    int newCol = j + dcol[d];

                    if(newRow >= 0 && newCol >= 0 && newRow < n && newCol < m ){
                        int newRem = rem - grid[newRow][newCol];

                        if(newRem >= 0 && !vis[newRow][newCol][newRem]){
                            vis[newRow][newCol][newRem] = true;
                            q.offer(new Pair(newRow , newCol, newRem));
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
class Pair{
    int row;
    int col;
    int remK;
    Pair(int row , int col , int remK){
        this.row = row;
        this.col = col;
        this.remK = remK;
    }
}