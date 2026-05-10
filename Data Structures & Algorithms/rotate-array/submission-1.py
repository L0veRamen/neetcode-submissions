class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k = k % n  # Handle cases where k > n
        
        # Create a temporary result list of the same size
        result = [0] * n
        
        # Place each element at its final position
        for i in range(n):
            result[(i + k) % n] = nums[i]
            
        # Copy the result back into the original array (in-place)
        for i in range(n):
            nums[i] = result[i]
