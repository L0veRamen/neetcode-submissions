class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> idx = new HashMap<>();  // val - > index
        for(int i = 0; i < nums.length; i++){
            idx.put(nums[i], i);
        }
        for(int i = 0; i < nums.length;i++){
            int diff = target - nums[i];
            if(idx.containsKey(diff) && idx.get(diff) != i){
                return new int[]{i, idx.get(diff) };
            }
        }
        return new int[0];
    }
}
