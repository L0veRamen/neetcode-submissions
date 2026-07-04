class PrefixTree {
    class TrieNode {
        private TrieNode[] children;
        private boolean isEnd;
        public TrieNode() {
            this.children = new TrieNode[26];
            this.isEnd = false;
        }
    }
    private TrieNode root;
    public PrefixTree() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char w : word.toCharArray()) {
            int index = w - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = dfs(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return dfs(prefix) != null;
    }

    private TrieNode dfs(String str) {
        TrieNode cur = root;
        for (char s : str.toCharArray()) {
            int index = s - 'a';
            if (cur.children[index] == null) {
                return null;
            }
            cur = cur.children[index];
        }
        return cur;
    }
}
