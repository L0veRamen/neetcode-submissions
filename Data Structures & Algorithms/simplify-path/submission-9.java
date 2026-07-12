class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] parts = path.split("/");

        for (String p : parts) {
            if (p.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
            } else if (!p.equals(".") && !p.isEmpty()) {
                stack.addLast(p);
            }
        }
        return "/" + String.join("/", stack);
    }
}