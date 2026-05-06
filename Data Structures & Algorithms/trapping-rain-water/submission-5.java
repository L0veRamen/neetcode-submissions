class Solution {
    public int trap(int[] height) {
        int res = 0;
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            int h = height[i];
            while (!st.isEmpty() && height[st.peek()] <= h) {
                int bottomH = height[st.pop()];
                if (st.isEmpty()) {
                    break;
                }
                int left = st.peek();
                int dh = Math.min(height[left], height[i]) - bottomH; // 面积的高
                res += dh * (i - left - 1);
            }
            st.push(i);
        }
        return res;
    }
}
