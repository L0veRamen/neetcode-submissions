class TrieNode():
    def __init__(self):
        self.children = {}
        self.isEnd = False

class WordDictionary:

    def __init__(self):
        self.root = TrieNode()
        
    def addWord(self, word: str) -> None:
        if not word:
            return

        node = self.root
        for c in word:
            if c not in node.children:
                node.children[c] = TrieNode()
            node = node.children[c]
        node.isEnd = True

    def search(self, word: str) -> bool:
        return self._dfs(word, 0, self.root)
        

    def _dfs(self, word, index, node) -> bool:
        if index == len(word):
            return node.isEnd
        
        char = word[index]
        
        if char == '.':
            # Try all possible children for wildcard
            for child in node.children.values():
                if self._dfs(word, index + 1, child):
                    return True
            return False
        else:
            # Regular character
            if char not in node.children:
                return False
            return self._dfs(word, index + 1, node.children[char])
