class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long sum = 0;
        int neg = 0 ;
        int mini = Integer.MAX_VALUE;
        for(int i = 0; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(matrix[i][j] < 0){
                    neg++;
                }
                int ab = Math.abs(matrix[i][j]);
                mini = Math.min(mini , ab);
                sum += ab;
            }
        }
        if(neg % 2 == 0 ) return sum;
        else return sum - 2 * mini;
    }
}

/*class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long ans = 0;
        int numberOfNegative = 0;
        int maxi = Integer.MIN_VALUE;
        boolean flag = false;
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < 0) {
                    numberOfNegative++;
                    if (matrix[i][j] > maxi) {
                        maxi = matrix[i][j];
                        flag = false; 
                        if ((i > 0 && matrix[i - 1][j] == 0) ||               
                            (i < n - 1 && matrix[i + 1][j] == 0) ||          
                            (j > 0 && matrix[i][j - 1] == 0) ||              
                            (j < n - 1 && matrix[i][j + 1] == 0)) {         
                            flag = true;
                        }
                    }
                }
                ans += Math.abs(matrix[i][j]);
                mini = Math.min(mini , Math.abs(matrix[i][j]));
            }
        }
        
        if (numberOfNegative % 2 == 0 || flag) return ans;
        return ans - 2 * Math.abs(mini); 
    }
}
 */