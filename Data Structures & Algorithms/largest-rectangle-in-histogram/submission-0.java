class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>(); // stores indices, monotonic increasing by height
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            // sentinel: treat position n as height 0 to flush remaining bars
            int curHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && curHeight < heights[stack.peek()]) {
                int mid = stack.pop(); // bar being evaluated as the shortest
                int left = stack.isEmpty() ? -1 : stack.peek(); // left boundary (exclusive)
                int width = i - left - 1;
                maxArea = Math.max(maxArea, heights[mid] * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
