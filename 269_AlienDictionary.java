class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for (String w : words)
            for (char c : w.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            if (w1.length() > w2.length() && w1.startsWith(w2)) return "";
            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    if (adj.get(w1.charAt(j)).add(w2.charAt(j)))
                        indegree.merge(w2.charAt(j), 1, Integer::sum);
                    break;
                }
            }
        }
        Queue<Character> q = new LinkedList<>();
        for (char c : indegree.keySet())
            if (indegree.get(c) == 0) q.offer(c);
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char c = q.poll();
            sb.append(c);
            for (char nei : adj.get(c))
                if (indegree.merge(nei, -1, Integer::sum) == 0) q.offer(nei);
        }
        return sb.length() == indegree.size() ? sb.toString() : "";
    }
}