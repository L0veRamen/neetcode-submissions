class Solution:
    def findMin(self, nums: List[int]) -> int:
        # (-1, n-1)
        l = -1
        r = len(nums) - 1
        
        while l + 1 < r:
            mid = (l + r) // 2
            if nums[mid] < nums[-1]:
                r = mid
            else:
                l = mid
        return nums[l + 1] # or nums[r]