class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        res = len(nums) + 1
        s = 0
        left = 0
        for right, n in enumerate(nums):
            s += nums[right]
            while s >= target:
                res = min(res, right - left + 1)
                s -= nums[left]
                left += 1
        return res if res <= len(nums) else 0
