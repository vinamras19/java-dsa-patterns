class Solution
{
    public int ladderLength(String beginWord, String endWord, List<String> wordList)
    {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int level = 1;
        while (!q.isEmpty())
        {
            int size = q.size();
            for (int i = 0; i < size; i++)
            {
                char[] cur = q.poll().toCharArray();
                for (int j = 0; j < cur.length; j++)
                {
                    char orig = cur[j];
                    for (char c = 'a'; c <= 'z'; c++)
                    {
                        if (c == orig) continue;
                        cur[j] = c;
                        String next = new String(cur);
                        if (next.equals(endWord)) return level + 1;
                        if (words.remove(next)) q.offer(next);
                    }
                    cur[j] = orig;
                }
            }
            level++;
        }
        return 0;
    }
}