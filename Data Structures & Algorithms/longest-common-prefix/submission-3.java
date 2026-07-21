class Solution {
    public String longestCommonPrefix(String[] strs) {
        String s0 = strs[0];
        for(int i = 0; i < s0.length();i++){
            char c = s0.charAt(i);
            for(String s: strs){
                if(i == s.length() || s.charAt(i) != c){
                    return s0.substring(0, i);
                }
            }
        }
        return s0;
    }
}