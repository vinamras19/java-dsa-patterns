class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] sortedQ = queries.clone();
        Arrays.sort(sortedQ);
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int j = 0;
        for (int q : sortedQ) {
            while (j < intervals.length && intervals[j][0] <= q)
                pq.offer(new int[]{intervals[j][1] - intervals[j][0] + 1, intervals[j++][1]});
            while (!pq.isEmpty() && pq.peek()[1] < q) pq.poll();
            map.put(q, pq.isEmpty() ? -1 : pq.peek()[0]);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) res[i] = map.get(queries[i]);
        return res;
    }
}