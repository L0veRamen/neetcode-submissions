class Solution:
    def canJump(self, nums: List[int]) -> bool:
        far = 0
        for i, jump in enumerate(nums):
            if i > far:
                return False
            far = max(far, i + jump)
        return True