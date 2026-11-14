class Solution:

    def encode(self, strs: List[str]) -> str:
        return "".join(f"{len(s)}*{s}" for s in strs)

    def decode(self, s: str) -> List[str]:
        res = []
        i = 0
        while i < len(s):
            star_index = s.find("*", i)
            length = int(s[i:star_index])
            start = star_index + 1
            end = start + length
            res.append(s[start:end])
            i = end
        return res