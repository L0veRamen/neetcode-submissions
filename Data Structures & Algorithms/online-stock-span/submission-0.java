class StockSpanner {

    private final Deque<int[]> stack = new ArrayDeque<>();
    private int curDay = -1; // 第一个next 调用算第0天

    public StockSpanner() {
        stack.push(new int[]{-1, 100001});
    }
    
    public int next(int price) {
        while(price >= stack.peek()[1]){
            stack.pop();
        }
        curDay++;
        int res = curDay - stack.peek()[0];
        stack.push(new int[]{curDay, price});
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */