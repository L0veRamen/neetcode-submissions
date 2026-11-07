class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        size = 0
        for x in nums:
            if x != val:
                nums[size] = x
                size += 1
        return size
