class FreqStack {

    // val -> how many times val currently exists in the stack
    private Map<Integer, Integer> freq;
    
    // frequency -> stack of elements that have this frequency
    // (top of each stack = most recently pushed at that frequency)
    private Map<Integer, Deque<Integer>> group;
    
    // current maximum frequency across all elements
    private int maxFreq;

    public FreqStack() {
        freq  = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        // Step 1: increment frequency of val
        int f = freq.merge(val, 1, Integer::sum); // freq[val]++, returns new value
        
        // Step 2: update global max frequency
        maxFreq = Math.max(maxFreq, f);
        
        // Step 3: add val to the stack at its new frequency level
        group.computeIfAbsent(f, k -> new ArrayDeque<>()).push(val);
    }

    public int pop() {
        // Step 1: pop from the highest frequency stack
        Deque<Integer> stack = group.get(maxFreq);
        int val = stack.pop();
        
        // Step 2: decrement its frequency
        freq.merge(val, -1, Integer::sum); // freq[val]--
        
        // Step 3: if that frequency level is now empty, lower maxFreq
        if (stack.isEmpty()) {
            maxFreq--;
        }
        
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */