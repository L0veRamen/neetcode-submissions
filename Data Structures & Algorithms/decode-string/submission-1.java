class Solution {
    public String decodeString(String s) {
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<StringBuilder> strStack = new ArrayDeque<>();
        
        StringBuilder currentString = new StringBuilder();
        int currentNum = 0;
        
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // Accumulate digits (handles multi-digit numbers like 12[a])
                currentNum = currentNum * 10 + (c - '0');
                
            } else if (c == '[') {
                // Save current state, start fresh inside brackets
                numStack.push(currentNum);
                strStack.push(currentString);
                currentNum = 0;
                currentString = new StringBuilder();
                
            } else if (c == ']') {
                // Pop repeat count and the string built before this bracket
                int repeatCount = numStack.pop();
                StringBuilder prevString = strStack.pop();
                
                // Repeat currentString k times, append to what came before
                for (int i = 0; i < repeatCount; i++) {
                    prevString.append(currentString);
                }
                currentString = prevString;
                
            } else {
                // Regular letter
                currentString.append(c);
            }
        }
        
        return currentString.toString();
    }
}