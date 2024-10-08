class Solution {
    public int numSubmat(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int height[] =  new int[m];

        int res = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ;j++){
                height[j] = mat[i][j] == 0 ? 0 : height[j] + 1;
                for(int k = j , min = height[j] ; k >= 0 && min > 0 ; k-- ){
                    min = Math.min(min , height[k]);
                    res += min;
                }
            }
        }
        return res;
    }
}