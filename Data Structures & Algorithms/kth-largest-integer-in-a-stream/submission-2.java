class KthLargest {

    private TreeMap<Integer, Integer> map; // score -> frequency
    private int k;
    private int size; // total number of scores

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.map = new TreeMap<>();
        this.size = 0;

        for (int num : nums) {
            add(num); // reuse add logic
        }
    }

    public int add(int val) {
        // Step 1: insert val into frequency map
        map.put(val, map.getOrDefault(val, 0) + 1);
        size++;

        // Step 2: walk from largest key down, count until we reach kth
        int count = 0;
        for (int key : map.descendingKeySet()) {
            count += map.get(key);
            if (count >= k) {
                return key; // this key is the kth largest
            }
        }

        return -1; // never reached given valid constraints
    }
}
