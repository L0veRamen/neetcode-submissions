class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        if (m > s2.length()) return false;

        int[] target = new int[26];
        for (char c : s1.toCharArray()) {
            target[c - 'a']++;
        }

        int[]window = new int[26];
        int left = 0;
        for(int right = 0; right < s2.length();right++){
            int rc = s2.charAt(right) - 'a';
            window[rc]++;
            while(window[rc] > target[rc]){
                window[s2.charAt(left)- 'a']--;
                left++;
            }
            if (right - left + 1 == m) return true;

        }
        return false;
    }
}
