class Solution {
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    private int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            char[] ch = w.toCharArray();
            TrieNode node = root;
            for (char c : ch) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.word = w;
        }
        return root;
    }

    private void dfs(char[][] board, int r, int c, TrieNode parent, List<String> res) {
        char ch = board[r][c];
        int idx = ch - 'a';
        TrieNode node = parent.children[idx];
        if (node == null)
            return;
        if (node.word != null) {
            res.add(node.word);
            node.word = null; // dedup
        }
        board[r][c] = '#';
        for (int[] d : DIRS) {
            int nr = d[0] + r;
            int nc = d[1] + c;
            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[nr].length
                && board[nr][nc] != '#') {
                dfs(board, nr, nc, node, res);
            }
        }
        board[r][c] = ch; // restor backtrack

        // lazy pruning
        boolean hasChild = false;
        for (TrieNode child : node.children) {
            if (child != null) {
                hasChild = true;
                break;
            }
        }
        if (!hasChild)
            parent.children[idx] = null;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        int rows = board.length;
        int cols = board[0].length;
        List<String> result = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, root, result);
            }
        }
        return result;
    }
}
