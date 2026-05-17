class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        count = defaultdict(int)
        left = res = maxFreq = 0
        for right, x in enumerate(s):
            count[ord(s[right]) - ord("A")] += 1
            maxFreq = max(maxFreq, count[ord(s[right]) - ord("A")])

            windowSize = right - left + 1
            if windowSize - maxFreq > k:
                count[ord(s[left]) - ord("A")] -= 1
                left += 1
            res = max(res, right - left + 1)
        return res
