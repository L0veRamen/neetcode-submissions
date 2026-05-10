class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0){
            return false;
        }
        Map<Character, Character> map = new HashMap<>(){
            {
                put('(', ')');
                put('[', ']');
                put('{', '}');
            }
        };

        Deque<Character> stack = new ArrayDeque<>();
        for(char c: s.toCharArray()){
            if(map.containsKey(c)){ // c是左括号
                stack.push(map.get(c));
            }else if(stack.isEmpty() || stack.pop() != c){ // c是右括号
                return false;
            }
        }
        return stack.isEmpty();
    }
}
