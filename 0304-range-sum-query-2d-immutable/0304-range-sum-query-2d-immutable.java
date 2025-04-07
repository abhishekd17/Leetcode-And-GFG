class NumMatrix {
    int preSumMatrix[][];
    public NumMatrix(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return;
        int n = matrix.length;
        int m = matrix[0].length;
        preSumMatrix = new int[n+1][m+1];

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                preSumMatrix[i][j] = matrix[i - 1][j - 1] + preSumMatrix[i - 1][j] + preSumMatrix[i][j - 1] - preSumMatrix[i - 1][j - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSumMatrix[row2 + 1][col2 + 1] + preSumMatrix[row1][col1] - preSumMatrix[row1][col2 + 1] - preSumMatrix[row2 + 1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */


 /*class NumMatrix {
    int matrix[][];
    public NumMatrix(int[][] matrix) {
        this.matrix = new int[matrix.length][matrix[0].length];
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        for(int i = row1 ; i <= row2 ; i++){
            for(int j = col1 ; j <= col2 ; j++){
                ans += matrix[i][j];
            }
        }
        return ans;
    }
}
/*
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */ 