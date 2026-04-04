class Solution
{
    public List<String> findItinerary(List<List<String>> tickets)
    {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for (List<String> t : tickets)
            adj.computeIfAbsent(t.get(0), k -> new PriorityQueue<>()).offer(t.get(1));
        LinkedList<String> res = new LinkedList<>();
        dfs("JFK", adj, res);
        return res;
    }

    private void dfs(String node, Map<String, PriorityQueue<String>> adj, LinkedList<String> res)
    {
        PriorityQueue<String> neighbors = adj.get(node);
        while (neighbors != null && !neighbors.isEmpty())
            dfs(neighbors.poll(), adj, res);
        res.addFirst(node);
    }
}