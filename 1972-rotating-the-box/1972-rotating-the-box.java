class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int n = box.length;
        int m = box[0].length;
        char ans[][] = new char[n][m];
        for(char[] c : ans){
            Arrays.fill(c , '.');
        }
        for(int i = 0 ; i  < n ; i++){
            int emptyIndex = m - 1;
            for(int j = m - 1 ; j >= 0 ; j--){
                if(box[i][j] == '*'){
                    ans[i][j] = '*';
                    emptyIndex = j - 1;
                }else if (box[i][j] == '#'){
                    ans[i][emptyIndex] = '#';
                    emptyIndex--;
                }
            }
        }
        char rotatedBox[][] = new char[m][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0; j < m ; j++){
                rotatedBox[j][n - i - 1] = ans[i][j];
            }
        }
        return rotatedBox;
    }
}