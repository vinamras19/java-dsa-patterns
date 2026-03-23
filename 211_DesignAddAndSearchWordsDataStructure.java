class WordDictionary {
    private WordDictionary[] children = new WordDictionary[26];
    private boolean end;

    public void addWord(String word) {
        WordDictionary node = this;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) node.children[i] = new WordDictionary();
            node = node.children[i];
        }
        node.end = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, this);
    }

    private boolean dfs(String word, int idx, WordDictionary node) {
        if (node == null) return false;
        if (idx == word.length()) return node.end;
        char c = word.charAt(idx);
        if (c == '.') {
            for (WordDictionary child : node.children) {
                if (dfs(word, idx + 1, child)) return true;
            }
            return false;
        }
        return dfs(word, idx + 1, node.children[c - 'a']);
    }
}