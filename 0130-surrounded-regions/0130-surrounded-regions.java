class Solution {
    private static void dfs(int row, int col, char board[][], int drow[], int dcol[]) {
        board[row][col] = '$';
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && board[nrow][ncol] == 'O') {
                dfs(nrow, ncol, board, drow, dcol);
            }
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int drow[] = { -1, 0, 1, 0 };
        int dcol[] = { 0, 1, 0, -1 };
        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O') {
                dfs(0, i, board, drow, dcol);
            }
            if (board[n - 1][i] == 'O') {
                dfs(n - 1, i, board, drow, dcol);
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0, board, drow, dcol);
            }
            if (board[i][m - 1] == 'O') {
                dfs(i, m - 1, board, drow, dcol);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'; 
                }
                if (board[i][j] == '$') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
