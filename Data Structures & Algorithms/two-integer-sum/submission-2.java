class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> seen = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int x = nums[i];
            if(seen.containsKey(target - x)){
                return new int[]{seen.get(target - x), i};
            }
            seen.put(x, i);
        }
        return new int[]{};
    }
}
