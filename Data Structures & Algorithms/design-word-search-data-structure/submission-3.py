class TrieNode:
    __slots__ = ("children", "is_end")

    def __init__(self) -> None:
        self.children: list[TrieNode | None] = [None] * 26
        self.is_end = False


class WordDictionary:
    def __init__(self):
        self.root = TrieNode()

    def addWord(self, word: str) -> None:
        node = self.root
        for ch in word:
            idx = ord(ch) - ord("a")
            if node.children[idx] is None:
                node.children[idx] = TrieNode()
            node = node.children[idx]
        node.is_end = True

    def search(self, word: str) -> bool:
        return self._dfs(word, 0, self.root)

    def _dfs(self, word: str, i: int, node: TrieNode) -> bool:
        # base case
        if node is None:
            return False
        # base case reach to end of word
        if i == len(word):
            return node.is_end

        ch = word[i]
        if ch == ".":
            for child in node.children:  # find all 26 branches
                if child is not None and self._dfs(word, i + 1, child):
                    return True
            return False
        else:
            idx = ord(ch) - ord("a")
            return self._dfs(word, i + 1, node.children[idx])
