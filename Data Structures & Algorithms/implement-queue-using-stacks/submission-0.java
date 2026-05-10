class MyQueue {

    /**
    * inbox: receive all push
    * outbox: serve all pop()/peek()
    */
    private Deque<Integer>inbox;
    private Deque<Integer>outbox;

    public MyQueue() {
        inbox = new ArrayDeque<>();
        outbox = new ArrayDeque<>();
    }
     // O(1) — just push to inbox
    public void push(int x) {
        inbox.push(x);
    }
    
    public int pop() {
        transfer();
        return outbox.pop();
    }
    
    public int peek() {
        transfer();
        return outbox.peek();
    }
    
    public boolean empty() {
        return inbox.isEmpty() && outbox.isEmpty();
    }

    // Core logic: reverse inbox into outbox (only when outbox is empty)
    private void transfer() {
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
                outbox.push(inbox.pop());
            }
        }
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