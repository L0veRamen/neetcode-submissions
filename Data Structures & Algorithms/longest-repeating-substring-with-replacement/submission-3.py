class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        res = 0
        left = 0
        count = defaultdict(int)
        max_count = 0
        for right, c in enumerate(s):
            count[c] += 1
            max_count = max(max_count, count[c])
            while(right -left + 1) - max_count > k:
                count[s[left]] -= 1
                left += 1
            res = max(res, right - left + 1)
        return res
