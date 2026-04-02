class Solution
{
    public void solve(char[][] board)
    {
        int m = board.length, n = board[0].length;
        for (int r = 0; r < m; r++)
        { dfs(board, r, 0);
            dfs(board, r, n - 1);
        }
        for (int c = 0; c < n; c++)
        { dfs(board, 0, c);
            dfs(board, m - 1, c);
        }
        for (int r = 0; r < m; r++)
            for (int c = 0; c < n; c++)
            {
                if (board[r][c] == 'O') board[r][c] = 'X';
                else if (board[r][c] == 'T') board[r][c] = 'O';
            }
    }

    private void dfs(char[][] board, int r, int c)
    {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O') return;
        board[r][c] = 'T';
        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}