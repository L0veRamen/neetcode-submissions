class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        if (m > s2.length()) {
            return false;
        }

        // 统计 s1 的每种字母的出现次数
        int[] cntS1 = new int[26];
        for (char c : s1.toCharArray()) {
            cntS1[c - 'a']++;
        }

        char[] s = s2.toCharArray();
        int[] cntT = new int[26]; // 对于 s2 的长为 m 的子串 t，统计 t 的每种字母的出现次数
        for (int i = 0; i < s.length; i++) {
            // 1. 进入窗口
            cntT[s[i] - 'a']++;
            if (i < m - 1) { // 窗口大小不足 m
                continue;
            }
            // 2. 判断子串 t 的每种字母的出现次数是否均与 s1 的相同
            if (Arrays.equals(cntS1, cntT)) {
                return true;
            }
            // 3. 离开窗口，为下一个循环做准备
            cntT[s[i - m + 1] - 'a']--;
        }
        return false;

    }
}
