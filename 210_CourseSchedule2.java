class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0) q.offer(i);
        int[] res = new int[numCourses];
        int idx = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            res[idx++] = cur;
            for (int nei : adj.get(cur))
                if (--indegree[nei] == 0) q.offer(nei);
        }
        return idx == numCourses ? res : new int[0];
    }
}