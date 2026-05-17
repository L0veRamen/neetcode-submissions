class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        if (m > s2.length()) return false;

        int[] count = new int[26]; // count[c] = freq in s1 
        for(char c: s1.toCharArray()){
            count[c- 'a']++;
        }

        for(int i = 0; i < s2.length();i++){
            count[s2.charAt(i) - 'a']--; // char enter window
            if(i - m + 1 < 0) continue;
            if(allZero(count)) return true;
            count[s2.charAt(i - m + 1) - 'a']++;
        }
        return false;
    }

    private boolean allZero(int[]count){
        for(int c: count){
            if (c != 0) return false;
        }
        return true;
    }
}
