class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int window_sum = 0;
        int left = 0;
        int min_len = n + 1;
        for (int right = 0; right < n; right++) {
            window_sum += nums[right];
            while (window_sum >= target) {
                min_len = Math.min(min_len, right - left + 1);
                window_sum -= nums[left];
                left++;
            }
        }
        return min_len <= n ? min_len : 0;
    }
}