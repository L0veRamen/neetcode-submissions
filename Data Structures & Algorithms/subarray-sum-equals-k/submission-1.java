class Solution {
    public int subarraySum(int[] nums, int k) {
        // step 1 initialize map with base case: prefix sum 0 = 1
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int currentSum = 0;
        int result = 0;

        for(int i: nums){
            //step2: accumulate running prefix sum
            currentSum += i;
            
            //step3: check how many past prefix sum allow (i,j) to sum target k
            result += map.getOrDefault(currentSum - k, 0);

            // step4: record current prefix Sum
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        return result;
    }
}