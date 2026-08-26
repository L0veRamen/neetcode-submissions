class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('*').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int star = s.indexOf('*', i);
            int length = Integer.parseInt(s.substring(i, star));
            res.add(s.substring(star + 1, star + 1 + length));
            i = star + 1 + length;
        }
        return res;
    }
}
