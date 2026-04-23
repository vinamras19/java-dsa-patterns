class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for (int[] p : prerequisites) adj.get(p[0]).add(p[1]);
        int[] state = new int[numCourses];
        for (int i = 0; i < numCourses; i++)
            if (hasCycle(adj, state, i)) return false;
        return true;
    }

    private boolean hasCycle(List<List<Integer>> adj, int[] state, int node) {
        if (state[node] == 1) return true;
        if (state[node] == 2) return false;
        state[node] = 1;
        for (int nei : adj.get(node))
            if (hasCycle(adj, state, nei)) return true;
        state[node] = 2;
        return false;
    }
}