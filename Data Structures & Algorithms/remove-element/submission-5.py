class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        size = len(nums)
        i = 0
        while i < size:
            if nums[i] == val:
                nums[i] = nums[size - 1]
                size -= 1
            else:
                i += 1
        return size
