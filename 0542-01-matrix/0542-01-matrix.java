// sc = O(1)
/*class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0) continue;
                int left= n + m ;
                int top= n + m;
                if(i-1>=0) top=mat[i-1][j];
                if(j-1>=0) left=mat[i][j-1];
                mat[i][j]=Math.min(top , left) + 1; 
            }
        }

        for(int i=n-1 ; i>=0; i--){
            for(int j = m - 1; j>=0 ;j--){
                if(mat[i][j]==0) continue;
                int bottom = m + n , right= m + n;
                if(i + 1 < n ) bottom=mat[i+1][j];
                if(j + 1 < m) right= mat[i][j+1];
                mat[i][j]=Math.min(mat[i][j] , Math.min(bottom , right ) + 1 );
            }
        }
        return mat;
    }
}

*/
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        Queue<Pair> q=new LinkedList<>();
        int ans[][]=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    mat[i][j] = 2;
                    q.add(new Pair(i , j , 0));
                }
            }
        }

            int drow[]={-1 , 0 ,1 ,0};
            int dcol[]={ 0 , 1 , 0 , -1 };
        while(!q.isEmpty()){
            Pair pair=q.poll();
            int ii=pair.row;
            int jj=pair.col;
            int ss=pair.steps;

            ans[ii][jj]=ss;
            for(int i=0;i<4;i++){
                int nrow= ii + drow[i];
                int ncol=jj + dcol[i];
                if(nrow >= 0 && nrow <n && ncol>=0 && ncol<m && mat[nrow][ncol]==1){
                    mat[nrow][ncol]=2;
                    q.add(new Pair(nrow , ncol , ss + 1));
                }
            }
        }
        return ans;
    }
}
class Pair{
    int row;
    int col;
    int steps;
    Pair(int row , int col , int steps){
        this.row=row;
        this.col=col;
        this.steps=steps;
    }
} 