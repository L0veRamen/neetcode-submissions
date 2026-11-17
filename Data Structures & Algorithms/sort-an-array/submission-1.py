from random import randint


class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        def quicksort(nums, start, end):
            if start >= end:
                return
            # left = 0
            # right = len(nums)-1
            left = start
            right = end
            pivot = randint(start, end)
            nums[left], nums[pivot] = nums[pivot], nums[left]
            key = nums[left]
            while left < right:
                while left < right and nums[right] >= key:
                    right -= 1
                nums[left] = nums[right]
                while left < right and nums[left] < key:
                    left += 1
                nums[right] = nums[left]
            nums[left] = key
            quicksort(nums, start, left - 1)
            quicksort(nums, left + 1, end)

        # 用手写的快排搞一下
        if len(nums) < 2:
            return nums
        quicksort(nums, 0, len(nums) - 1)
        return nums
