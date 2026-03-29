class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        backtrack(board, 0, new HashSet<>(), new HashSet<>(), new HashSet<>(), res);
        return res;
    }

    private void backtrack(char[][] board, int row, Set<Integer> cols,
                           Set<Integer> diag, Set<Integer> antiDiag, List<List<String>> res) {
        if (row == board.length) {
            List<String> copy = new ArrayList<>();
            for (char[] r : board) copy.add(new String(r));
            res.add(copy);
            return;
        }
        for (int c = 0; c < board.length; c++) {
            if (cols.contains(c) || diag.contains(row - c) || antiDiag.contains(row + c)) continue;
            board[row][c] = 'Q';
            cols.add(c); diag.add(row - c); antiDiag.add(row + c);
            backtrack(board, row + 1, cols, diag, antiDiag, res);
            board[row][c] = '.';
            cols.remove(c); diag.remove(row - c); antiDiag.remove(row + c);
        }
    }
}