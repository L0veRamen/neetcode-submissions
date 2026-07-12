class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) { // s 长度必须是偶数
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> closeToOpen = new HashMap<>();
        closeToOpen.put(')', '(');
        closeToOpen.put('}', '{');
        closeToOpen.put(']', '[');

        for (char c : s.toCharArray()) {
            if (!closeToOpen.containsKey(c)) {
                stack.push(c);
            } else if (stack.isEmpty() || stack.pop() != closeToOpen.get(c)) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
