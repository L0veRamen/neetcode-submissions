class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        cnt = defaultdict(int)
        left = 0
        res = 0
        for right, x in enumerate(s):
            cnt[x]+= 1
            while cnt[x] > 1:
                cnt[s[left]]-=1
                left += 1
            res = max(res, right - left + 1)
        return res