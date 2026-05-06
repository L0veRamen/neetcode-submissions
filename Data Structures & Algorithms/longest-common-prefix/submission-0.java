class Solution {
    public String longestCommonPrefix(String[] strs) {
        // flower
        // flow
        // flight
        String s0 = strs[0];
        for(int j = 0; j < s0.length();j++){ //left to right
            char c = s0.charAt(j); 
            for(String s: strs){ // top to bottom  
                if(j == s.length() || s.charAt(j) != c){
                    return s0.substring(0,j);
                }
            }
        }
        return s0;
    }
}