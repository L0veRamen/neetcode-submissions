class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        res = len(nums)
        left = -1
        right = len(nums)

        while left + 1 < right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                return mid
            if nums[mid] > target:
                res = mid
                right = mid
            else:
                left = mid
        return res