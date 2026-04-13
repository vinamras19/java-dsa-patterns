class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, max = 1;
        int[][] memo = new int[m][n];
        for (int r = 0; r < m; r++)
            for (int c = 0; c < n; c++)
                max = Math.max(max, dfs(matrix, r, c, memo));
        return max;
    }

    private int dfs(int[][] matrix, int r, int c, int[][] memo) {
        if (memo[r][c] != 0) return memo[r][c];
        int best = 1;
        for (int[] d : dirs) {
            int nr = r + d[0], nc = c + d[1];
            if (nr >= 0 && nr < matrix.length && nc >= 0 && nc < matrix[0].length
                    && matrix[nr][nc] > matrix[r][c])
                best = Math.max(best, 1 + dfs(matrix, nr, nc, memo));
        }
        return memo[r][c] = best;
    }
}