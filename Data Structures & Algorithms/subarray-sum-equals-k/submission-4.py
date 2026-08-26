class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = defaultdict(int)
        count[0] = 1
        res = s = 0
        for x in nums:
            s += x
            res += count[s - k]
            count[s] += 1
        return res