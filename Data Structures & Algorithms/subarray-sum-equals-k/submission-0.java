class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        
        // pass1: build prefix Sum
        int[] prefix = new int[n + 1];
        for(int i = 0; i < n; i++){
            prefix[i + 1] = nums[i] + prefix[i];
        }

        // pass2: count how many prefix[i] == prefix[j] - k
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int j = 0; j <= n; j++){
            // how many earlier prefix Sum equal to prefix[j] - k
            res += map.getOrDefault(prefix[j] - k, 0);
            // record current prefix sum
            map.put(prefix[j], map.getOrDefault(prefix[j], 0) + 1);
        }
        return res;
    }
}