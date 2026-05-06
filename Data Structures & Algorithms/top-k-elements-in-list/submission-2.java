class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create buckets — index = frequency
        // Max possible frequency is nums.length
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        // Step 3: Place each number into its frequency bucket
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int num  = entry.getKey();
            int freq = entry.getValue();
            bucket[freq].add(num);
        }

        // Step 4: Scan right to left, collect top k elements
        int[] result = new int[k];
        int idx = 0;

        for (int freq = nums.length; freq >= 1 && idx < k; freq--) {
            for (int num : bucket[freq]) {
                result[idx++] = num;
                if (idx == k) break;
            }
        }

        return result;
    }
}