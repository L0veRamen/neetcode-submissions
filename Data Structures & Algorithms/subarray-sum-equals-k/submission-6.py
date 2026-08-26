class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = defaultdict(int)
        res = curSum = 0
        for x in nums:
            count[curSum] += 1
            curSum += x
            res += count[curSum - k]
        return res