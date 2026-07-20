class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        s0 = strs[0]
        for j, c in enumerate(s0): # scan left to right 
            for s in strs: # scan top to bottom
                if j == len(s) or s[j] != c:
                    return s0[:j] # 0 to j-1 longest common prefix
        return s0