class KthLargest {
    private final int[] freq = new int[20001]; // index 0..20000 → score -10000..10000
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) add(num);
    }

    public int add(int val) {
        freq[val + 10000]++; // -10000→0, 0→10000, 10000→20000

        int count = 0;
        for (int i = 20000; i >= 0; i--) {
            count += freq[i];
            if (count >= k) {
                return i - 10000; // reverse mapping back to score
            }
        }

        return -1;
    }
}
