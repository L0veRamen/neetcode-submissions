class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chs = s.toCharArray();
        int res = 0;
        int n = chs.length;
        int left = 0;
        int[] count = new int[128];
        for (int right = 0; right < n; right++) {
            char c = chs[right];
            count[c]++;
            while (count[c] > 1) {
                count[chs[left]]--;
                left++;
            }
            res = Math.max(right - left + 1, res);
        }
        return res;
    }
}
