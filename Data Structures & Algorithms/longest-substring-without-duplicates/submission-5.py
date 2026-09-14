class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        res = left = 0
        count = defaultdict(int)
        for right, c in enumerate(s):
            count[c] += 1
            while count[c] > 1:
                count[s[left]] -= 1
                left += 1
            res = max(res, right - left + 1)
        return res