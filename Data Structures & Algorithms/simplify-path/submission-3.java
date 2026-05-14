class Solution {
    public String simplifyPath(String path) {
        List<String> st = new ArrayList<>();
        for(String p: path.split("/")){
            if(p.equals(".") || p.isEmpty()){
                continue;
            }
            if(!p.equals("..")){
                st.add(p);
            }else if(!st.isEmpty()){
                st.removeLast(); 
            }
        }
        return "/" + String.join("/", st);
    }
}