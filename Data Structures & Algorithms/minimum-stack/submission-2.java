class MinStack {

    private final Deque<int[]> st = new ArrayDeque<>();

    public MinStack() {
        st.push(new int[] { 0, Integer.MAX_VALUE });
    }

    public void push(int val) {
        st.push(new int[] { val, Math.min(getMin(), val) });
    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return st.peek()[0];
    }

    public int getMin() {
        return st.peek()[1];
    }
}
