class Solution:
    def trap(self, height: List[int]) -> int:
        total_water = 0
        n = len(height)

        # Skip first and last positions as they can't trap water
        for i in range(1, n - 1):
            # Find maximum height on left
            left_max = max(height[0:i])
            # Find maximum height on right
            right_max = max(height[i + 1 : n])

            # Calculate water trapped at current position
            min_height = min(left_max, right_max)
            if min_height > height[i]:
                total_water += min_height - height[i]

        return total_water