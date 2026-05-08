class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 如果当前学号在[1,n]中, 但真身没在正确的位置上
            while (1 <= nums[i] && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                //  交换 nums[i] nums[j], j 是 i 的学号
                int j = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        // 找到第一个学号和座位不匹配的学生
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 所有学生都坐在座位上
        return n + 1;
    }
}