class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        left = -1
        right = n 
        last = nums[-1]
        while left + 1 < right:
            mid = (left + right) // 2
            x = nums[mid]
            if x == target:
                return mid
            same_side = (x > last) == (target > last) 
            if same_side and x < target:  # mid  target all in the left side
                left = mid  
            elif same_side: 
                right = mid
            elif x > last: # mid at left,  target at right
                left = mid
            else:
                right = mid
        return -1