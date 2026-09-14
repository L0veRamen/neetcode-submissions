class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        res = left = 0
        seen = set()
        for right, c in enumerate(s):
            while c in seen:
                seen.remove(s[left])
                left += 1
            seen.add(c)
            res = max(res, right - left + 1)
        return res