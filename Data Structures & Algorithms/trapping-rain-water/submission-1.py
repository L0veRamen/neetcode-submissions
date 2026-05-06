class Solution:
    def trap(self, height: List[int]) -> int:
        stack = []  # Store indices of bars
        total_water = 0

        for current in range(len(height)):
            # While we have a higher bar that can trap water
            while stack and height[current] > height[stack[-1]]:
                top = stack.pop()

                if not stack:
                    break

                # Calculate trapped water between bars
                distance = current - stack[-1] - 1
                bounded_height = min(height[current], height[stack[-1]]) - height[top]
                total_water += distance * bounded_height

            stack.append(current)

        return total_water