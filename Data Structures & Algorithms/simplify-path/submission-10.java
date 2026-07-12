class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        for (String p : path.split("/")) {
            if(p.isEmpty() || p.equals(".")){
                continue;
            }else if(!p.equals("..")){
               stack.add(p);
            }else if(!stack.isEmpty()) {
                stack.removeLast();
            }
        }
        return "/" + String.join("/", stack);
    }
}