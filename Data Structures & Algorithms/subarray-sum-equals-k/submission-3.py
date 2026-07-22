class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = defaultdict(int)
        res = s = 0
        for x in nums:
            count[s] += 1
            s += x
            res += count[s - k]
        return res