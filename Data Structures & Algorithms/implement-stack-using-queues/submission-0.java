class MyStack {
    private Queue<Integer> q;

    public MyStack() {
        q = new ArrayDeque<>();
    }

    // O(n) — rotate new element to front
    public void push(int x) {
        q.offer(x); // add at back
        int rotations = q.size() - 1;
        for(int i = 0;i< rotations;i++){
            q.offer(q.poll()); // move front element to back
        }
        // now x is at the front = stack top
    }
    // O(1)
    public int pop() {
        return q.poll(); //front = stack top
    }
    // O(1)
    public int top() {
        return q.peek();
    }
    // O(1)
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */