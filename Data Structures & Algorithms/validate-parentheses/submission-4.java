class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();

        for(char c: s.toCharArray()){
            // push all open brackets
            if(c == '(' || c == '[' || c == '{'){
                st.push(c);
            }else{
                // close bracket: stack must be non-empty and top must match
                if(st.isEmpty()) return false;
                
                char top = st.pop();
                if (c == ')' && top != '(') return false;
                if (c == ']' && top != '[') return false;
                if (c == '}' && top != '{') return false;
            }
        }
        return st.isEmpty();
    }
}
