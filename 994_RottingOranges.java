class Solution {

    public int orangesRotting(int[][] grid) {

        int m = grid.length, n = grid[0].length, fresh = 0, time = 0;
        Queue<int[]> q = new LinkedList<>();

        for (int r = 0; r < m; r++)
            for (int c = 0; c < n; c++)
            {
                if (grid[r][c] == 2) q.offer(new int[]{r, c});
                else if (grid[r][c] == 1) fresh++;
            }
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!q.isEmpty() && fresh > 0)
        {
            int size = q.size();
            for (int i = 0; i < size; i++)
            {
                int[] cur = q.poll();
                for (int[] d : dirs)
                {
                    int nr = cur[0] + d[0], nc = cur[1] + d[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1)
                    {
                        grid[nr][nc] = 2;
                        fresh--;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}