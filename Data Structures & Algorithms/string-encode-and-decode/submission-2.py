class Solution:

    def encode(self, strs: List[str]) -> str:
        res = ""
        for s in strs:
            res += str(len(s)) + "*" + s
        return res

    def decode(self, s: str) -> List[str]:
        # 5*Hello5*World
        res = []
        i = 0
        while i < len(s):
            star = s.index("*", i)
            length = int(s[i:star])
            res.append(s[star + 1: star+1+length])
            i = star + 1 + length
        return res
