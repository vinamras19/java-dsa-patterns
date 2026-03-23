class Solution {
    private int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode node = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (node.children[i] == null) node.children[i] = new TrieNode();
                node = node.children[i];
            }
            node.word = w;
        }
        List<String> res = new ArrayList<>();
        for (int r = 0; r < board.length; r++)
            for (int c = 0; c < board[0].length; c++)
                dfs(board, r, c, root, res);
        return res;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> res) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) return;
        char ch = board[r][c];
        if (ch == '#' || node.children[ch - 'a'] == null) return;
        node = node.children[ch - 'a'];
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }
        board[r][c] = '#';
        for (int[] d : dirs) dfs(board, r + d[0], c + d[1], node, res);
        board[r][c] = ch;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }
}