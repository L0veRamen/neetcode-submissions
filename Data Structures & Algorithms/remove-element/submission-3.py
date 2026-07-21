class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        p = 0
        for i, x in enumerate(nums):
            if x != val:
                nums[p] = x
                p += 1
        return p 