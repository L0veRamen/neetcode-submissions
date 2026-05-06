class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> idx = new HashMap<>();
        for(int i=0; ;i++){
            int x = nums[i];
            if(idx.containsKey(target - x)){
                return new int[]{idx.get(target -x), i};
            }
            idx.put(x, i);
        }
    }
}
