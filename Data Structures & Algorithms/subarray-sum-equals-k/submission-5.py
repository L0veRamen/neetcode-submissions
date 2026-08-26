class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = defaultdict(int)
        count[0] = 1
        res = curSum = 0
        for x in nums:
            curSum += x
            res += count[curSum - k]
            count[curSum] += 1
        return res