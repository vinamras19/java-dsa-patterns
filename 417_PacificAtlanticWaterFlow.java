class Solution
{
    public List<List<Integer>> pacificAtlantic(int[][] heights)
    {
        int m = heights.length, n = heights[0].length;
        boolean[][] pac = new boolean[m][n], atl = new boolean[m][n];
        for (int r = 0; r < m; r++)
        {
            dfs(heights, pac, r, 0);
            dfs(heights, atl, r, n - 1);
        }
        for (int c = 0; c < n; c++)
        {
            dfs(heights, pac, 0, c);
            dfs(heights, atl, m - 1, c);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < m; r++)
            for (int c = 0; c < n; c++)
                if (pac[r][c] && atl[r][c]) res.add(List.of(r, c));
        return res;
    }

    private void dfs(int[][] heights, boolean[][] visited, int r, int c)
    {
        if (r < 0 || r >= heights.length || c < 0 || c >= heights[0].length || visited[r][c]) return;
        visited[r][c] = true;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] d : dirs)
            if (r + d[0] >= 0 && r + d[0] < heights.length && c + d[1] >= 0 && c + d[1] < heights[0].length
                    && heights[r + d[0]][c + d[1]] >= heights[r][c])
                dfs(heights, visited, r + d[0], c + d[1]);
    }
}