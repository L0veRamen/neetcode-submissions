class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] cs = s.toCharArray();
        int len = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < cs.length; right++) {
            map.put(cs[right], map.getOrDefault(cs[right], 0) + 1);
            while (map.get(cs[right]) > 1) {
                map.put(cs[left], map.get(cs[left]) - 1);
                left++;
            }
            len = Math.max(len, right - left + 1);
        }
        return len;
    }
}
