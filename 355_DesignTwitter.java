class Twitter {

    private int time;
    private Map<Integer, Set<Integer>> follows;
    private Map<Integer, List<int[]>> tweets;

    public Twitter() {
        follows = new HashMap<>();
        tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{time++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        follows.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        for (int fid : follows.get(userId)) {
            List<int[]> t = tweets.getOrDefault(fid, List.of());
            if (!t.isEmpty()) {
                int idx = t.size() - 1;
                int[] latest = t.get(idx);
                maxHeap.offer(new int[]{latest[0], latest[1], fid, idx});
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!maxHeap.isEmpty() && res.size() < 10) {
            int[] top = maxHeap.poll();
            res.add(top[1]);
            int idx = top[3] - 1;
            if (idx >= 0) {
                int[] prev = tweets.get(top[2]).get(idx);
                maxHeap.offer(new int[]{prev[0], prev[1], top[2], idx});
            }
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        follows.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> f = follows.get(followerId);
        if (f != null) f.remove(followeeId);
    }
}