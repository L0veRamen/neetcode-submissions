class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        cnt = defaultdict(int)
        cnt[0] = 1
        res = s = 0
        for x in nums:
            s += x
            res += cnt[s - k]
            cnt[s] += 1
        return res
        
