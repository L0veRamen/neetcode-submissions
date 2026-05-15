class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n + 1]; // prefix[i] = sum of nums[0, ...i-1]
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        int min_len = Integer.MAX_VALUE;
        for(int left = 0; left < n; left++){
            // find the smallest right prefix[right] - prefix[left] >= target
            int needed = prefix[left] + target;
            int lo = left + 1;
            int hi = n;
            while(lo < hi){
                int mid = lo + (hi - lo) / 2;
                if(prefix[mid] >= needed) hi = mid;
                else lo = mid + 1;
            }
            if(prefix[lo] >= needed){
                min_len = Math.min(min_len, lo - left);
            }
        }
        return min_len == Integer.MAX_VALUE ? 0 : min_len;
    }
}