class Solution {
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> result = new ArrayList<>();
        int rows = board.length, cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, root, result); // valid by construction, no check needed
            }
        }
        return result;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode node = root;
            for (char ch : w.toCharArray()) {
                int i = ch - 'a';
                if (node.children[i] == null)
                    node.children[i] = new TrieNode();
                node = node.children[i];
            }
            node.word = w;
        }
        return root;
    }

    // Precondition (enforced by every caller, see below): 0 <= r < rows, 0 <= c < cols.
    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> result) {
        char ch = board[r][c]; // safe: precondition guarantees in-bounds
        if (ch == '#')
            return;
        TrieNode next = node.children[ch - 'a'];
        if (next == null)
            return;

        if (next.word != null) {
            result.add(next.word);
            next.word = null;
        }

        int rows = board.length, cols = board[0].length;
        board[r][c] = '#';
        for (int[] d : DIRS) {
            int nr = r + d[0], nc = c + d[1];
            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) { // <-- bounds check moved here
                dfs(board, nr, nc, next, result);
            }
        }
        board[r][c] = ch;

        boolean hasChild = false;
        for (TrieNode t : next.children)
            if (t != null) {
                hasChild = true;
                break;
            }
        if (!hasChild && next.word == null)
            node.children[ch - 'a'] = null;
    }
}