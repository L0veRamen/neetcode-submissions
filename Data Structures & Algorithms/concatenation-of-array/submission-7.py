class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = [0] * (n * 2)
        for i, x in enumerate(nums):
            res[i] = res[i + n] = x
        return res