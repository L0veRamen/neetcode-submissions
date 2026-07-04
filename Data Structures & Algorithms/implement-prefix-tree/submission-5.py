class TrieNode:
    def __init__(self):
        self.children = defaultdict(TrieNode)
        self.is_end = False

class PrefixTree:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        cur_node = self.root
        for ch in word:
            cur_node = cur_node.children[ch]
        cur_node.is_end = True

    def search(self, word: str) -> bool:
        cur_node = self._dfs(word)
        return cur_node is not None and cur_node.is_end

    def startsWith(self, prefix: str) -> bool:
        return self._dfs(prefix) is not None

    def _dfs(self, s: str) -> TrieNode | None:
        node = self.root
        for ch in s:
            node = node.children.get(ch)
            if node is None:
                return None
        return node
