class TrieNode:
    __slots__ = ("children", "word")

    def __init__(self):
        self.children: defaultdict[str, TrieNode] = defaultdict(TrieNode)
        self.word: str | None = None


class Solution:

    @staticmethod
    def _buildTrie(words: list[str]) -> TrieNode:
        root = TrieNode()
        for w in words:
            node = root
            for ch in w:
                node = node.children[ch]
            node.word = w
        return root

    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        root = self._buildTrie(words)
        rows, cols = len(board), len(board[0])
        res: list[str] = []
        DIRS = ((1, 0), (-1, 0), (0, -1), (0, 1))

        def dfs(r: int, c: int, node: TriNode) -> None:
            ch = board[r][c]
            if ch == "#" or ch not in node.children:
                return
            nxt = node.children[ch]

            if nxt.word is not None:
                res.append(nxt.word)
                nxt.word = None

            board[r][c] = "#"
            for dr, dc in DIRS:
                nr, nc = r + dr, c + dc
                if 0 <= nr < rows and 0 <= nc < cols:
                    dfs(nr, nc, nxt)
            board[r][c] = ch
            if not nxt.children and nxt.word is None:
                del node.children[ch]

        for r in range(rows):
            for c in range(cols):
                dfs(r, c, root)
        return res
