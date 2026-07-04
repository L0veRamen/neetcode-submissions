class TrieNode:
    def __init__(self):
        self.children: list[TrieNode | None] = [None] * 26
        self.is_end = False

class PrefixTree:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        cur_node = self.root
        for ch in word:
            index = ord(ch) - ord('a')
            if cur_node.children[index] is None:
                cur_node.children[index] = TrieNode()
            cur_node = cur_node.children[index]
        cur_node.is_end = True

    def search(self, word: str) -> bool:
        cur_node = self._dfs(word)
        return cur_node is not None and cur_node.is_end

    def startsWith(self, prefix: str) -> bool:
        return self._dfs(prefix) is not None

    def _dfs(self, s: str) -> TrieNode | None:
        node = self.root
        for ch in s:
            index = ord(ch) - ord('a')
            if node.children[index] is None:
                return None
            node = node.children[index]
        return node

