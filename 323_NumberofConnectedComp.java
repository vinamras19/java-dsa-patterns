class Solution {
    private int[] parent, rank;

    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        int components = n;
        for (int[] e : edges)
            if (union(e[0], e[1])) components--;
        return components;
    }

    private int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private boolean union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa == pb) return false;
        if (rank[pa] < rank[pb]) { int t = pa; pa = pb; pb = t; }
        parent[pb] = pa;
        if (rank[pa] == rank[pb]) rank[pa]++;
        return true;
    }
}