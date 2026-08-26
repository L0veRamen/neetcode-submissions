class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        output = [1] * n
        # output[i] = product of everything before i
        for i in range(1, n):
            output[i] = output[i - 1] * nums[i - 1]
        
        suf = 1
        for i in range(n - 1, -1, -1):
            output[i] *= suf
            suf *= nums[i]
        
        return output