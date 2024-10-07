class Solution {
    public boolean checkPartitioning(String s) {
        int n = s.length();

        boolean[][] p = new boolean[n][n];

       for(int i = n - 1 ; i >= 0  ; i--){
        for(int j = i ; j < n ;j++){
            if(s.charAt(i) == s.charAt(j) && (j  - i < 3 || p[i + 1][j - 1])){
                p[i][j] = true;
            }
        }
       }

      for(int i = 1 ; i < n - 1 ; i++){
        for(int j = i ; j < n - 1 ; j++){
            if(p[0][i - 1] && p[i][j] && p[j + 1][n - 1]) return true;
        }
      }
      return false;
    }
}