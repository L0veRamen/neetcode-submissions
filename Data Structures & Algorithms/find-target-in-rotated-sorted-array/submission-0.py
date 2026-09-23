class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l = -1
        r = len(nums) - 1 # (-1, n-1)
        while l + 1 < r:
            mid = (l + r) // 2
            x = nums[mid]
            if target > nums[-1] >= x: # target 在第一段，x在第二段
                r = mid
            elif x > nums[-1] >= target: # target在第二段，x在第一段
                l = mid
            elif x >= target: # x和target在同一段
                r = mid
            else:
                l = mid

        return r if nums[r] == target else -1