// optimal solution

class Solution {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int col=1;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    if(j!=0){
                        matrix[0][j]=0;
                    }
                    else{
                        col=0;
                    }
                }
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j]!=0){
                    if(matrix[0][j]==0 || matrix[i][0]==0){
                        matrix[i][j]=0;
                    }
                }
            }
        }

        if(matrix[0][0]==0){
            for(int j=0;j<m;j++){
                matrix[0][j]=0;
            }
        }
        if(col==0){
            for(int i=0;i<n;i++){
                matrix[i][0]=0;
            }
        }
    }
}









/*class Solution {

    public static void markrow(int[][] matrix, int n, int m, int i) {
        for (int j = 0; j < m; j++) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = -1;
            }
        }
    }

    public static void markcol(int[][] matrix, int n, int m, int j) {
        for (int i = 0; i < n; i++) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = -1;
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    markrow(matrix, n, m, i);
                    markcol(matrix, n, m, j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}*/





/*// first approach
class Solution {
    public void setZeroes(int[][] nums) {
        int n=nums.length;
        int m=nums[0].length;

        boolean row[]=new boolean[n];
        boolean col[]=new boolean[m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(nums[i][j]==0){
                    row[i]=true;
                    col[j]=true;
                }
            }
        }

        for(int i=0;i<n;i++){
            if(row[i]){
                for(int j=0;j<m;j++){
                    nums[i][j]=0;
                }
            }
        }

        for(int j=0;j<m;j++){
            if(col[j]){
                for(int i=0;i<n;i++){
                    nums[i][j]=0;
                }
            }
        }
    }
} */