class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        cnt = defaultdict(int)

        left = max_count = max_len = 0
        for right, c in enumerate(s):
            cnt[c] += 1
            max_count = max(max_count, cnt[c])
            if (right - left + 1) - max_count > k:
                cnt[s[left]] -= 1
                left += 1
            max_len = max(max_len, right - left + 1)
        return max_len