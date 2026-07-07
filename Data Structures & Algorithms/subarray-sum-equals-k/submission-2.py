class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = defaultdict(int)
        res = 0
        prefix_sum = 0

        for n in nums:
            count[prefix_sum] += 1
            prefix_sum += n
            res += count[prefix_sum - k]

        return res
