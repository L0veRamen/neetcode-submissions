class MyQueue {

    private Deque<Integer> stack;

    public MyQueue() {
        stack = new ArrayDeque<>();        
    }
    // O(1)
    public void push(int x) {
        stack.push(x);
    }
    
    // O(n)  — recurse to bottom, return it, restore the rest
    public int pop() {
        int top = stack.pop();
        if (stack.isEmpty()) {
            return top;           // base case: this is the front
        }
        int front = pop();        // recurse deeper to find front
        stack.push(top);          // restore on the way back up
        return front;
    }
    // O(n)
    public int peek() {
        int top = stack.pop();
        if(stack.isEmpty()){
            stack.push(top); // restore before returning
            return top;
        }
        int front = peek();       // recurse deeper
        stack.push(top);          // restore on the way back up
        return front;
    }
    
    // O(1)
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */