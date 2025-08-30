class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    char current=board[i][j];
                    board[i][j]='.';
                    if(!isValid(board ,current , i , j)){
                        return false;
                    }
                    board[i][j]=current;
                }
            }
        }
        return true;
    }
    private boolean isValid(char board[][] , char c, int row ,int col){
        for(int i=0;i<9;i++){
            if(board[row][i]==c ) return false;
            if(board[i][col]==c ) return false;
            if(board[3*(row/3) + (i/3)][3*(col/3) + (i%3)]==c) return false;
        }
        return true;
    }
}