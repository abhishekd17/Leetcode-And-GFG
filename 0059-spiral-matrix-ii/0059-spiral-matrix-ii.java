class Solution {
    public int[][] generateMatrix(int n) {
        int matrix[][] = new int[n][n];
        int total_elements = 0;
        int top = 0 , left = 0 , bottom = n - 1 , right = n - 1;
        int x = 1;
        while(total_elements < n * n){
            for(int i = left ; i <= right && total_elements <= n * n; i++){
                matrix[top][i] = x++;
                total_elements++;
            }
            top++;
            for(int i = top ; i <= bottom && total_elements <= n * n ; i++){
                matrix[i][right] = x++;
                total_elements++;
            }
            right--;
            for(int i = right ; i >= left && total_elements <= n * n ; i--){
                matrix[bottom][i] = x++;
                total_elements++;
            }
            bottom--;
            for(int i = bottom ; i >= top && total_elements <= n * n ; i--){
                matrix[i][left] = x++;
                total_elements++;
            }
            left++;
        }
        return matrix;
    }
}