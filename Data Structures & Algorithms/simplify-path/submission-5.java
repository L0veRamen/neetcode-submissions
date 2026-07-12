class Solution {
    public String simplifyPath(String path) {
        List<String> stack = new ArrayList<>();
        for (String s : path.split("/")) {
            if (s.isEmpty() || s.equals(".")) {
                continue;
            }
            if (!s.equals("..")) {
                stack.add(s);
            } else if (!stack.isEmpty()) {
                stack.removeLast();
            }
        }
        return "/" + String.join("/", stack);
    }
}