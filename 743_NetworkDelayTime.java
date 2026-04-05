class Solution
{
    public int networkDelayTime(int[][] times, int n, int k)
    {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int[] t : times) adj.get(t[0]).add(new int[]{t[1], t[2]});
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});
        while (!pq.isEmpty())
        {
            int[] cur = pq.poll();
            if (cur[1] > dist[cur[0]]) continue;
            for (int[] nei : adj.get(cur[0]))
            {
                int d = cur[1] + nei[1];
                if (d < dist[nei[0]]) {
                    dist[nei[0]] = d;
                    pq.offer(new int[]{nei[0], d});
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) res = Math.max(res, dist[i]);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}