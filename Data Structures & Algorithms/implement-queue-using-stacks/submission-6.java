class MyQueue {

    private ArrayDeque<Integer> in;
    private ArrayDeque<Integer> out;

    public MyQueue() {
        in = new ArrayDeque<>();
        out = new ArrayDeque<>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        transfer();
        return out.pop();
    }
    
    public int peek() {
        transfer();
        return out.peek();
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    private void transfer(){
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.add(in.removeLast());
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