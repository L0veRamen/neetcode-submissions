class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[][] map = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            map[i][0] = nums[i];
            map[i][1] = i;
        }

        Arrays.sort(map, Comparator.comparingInt(a -> a[0]));

        int i = 0, j = nums.length - 1;
        while (i < j) {
            int cur = map[i][0] + map[j][0];
            if (cur == target) {
                return new int[]{Math.min(map[i][1], map[j][1]),
                                 Math.max(map[i][1], map[j][1])};
            } else if (cur < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[0];
    }
}
