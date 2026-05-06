class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        n = len(word1)
        m = len(word2)
        ans = []
        i = 0
        while i < n or i < m:
            if i < n:
                ans.append(word1[i])
            if i < m:
                ans.append(word2[i])
            i += 1
        return "".join(ans)
