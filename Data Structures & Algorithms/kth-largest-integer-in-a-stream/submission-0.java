class KthLargest {
    private PriorityQueue<Integer> minHeap;

    private int k; // target

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for (int n : nums) {
            add(n);
        }
    }

    public int add(int val) {
        // minHeap.offer(val);
        // if(minHeap.size() > k){
        //     minHeap.poll();
        // }
        if (minHeap.size() < k) { // not full yet → always add
            minHeap.offer(val);
        } else if (val > minHeap.peek()) { // full AND val beats kth largest → swap
            minHeap.poll();
            minHeap.offer(val);
        }
        // if full AND val <= peek → val not in top-k, ignore it
        return minHeap.peek();
    }
}

