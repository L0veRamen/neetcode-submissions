class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(0, 0, s, path, res);
        return res;
    }

    private void dfs(int i, int start, String s, List<String> path, List<List<String>> res) {
        if (i == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        // not cut
        if (i < s.length() - 1) {
            dfs(i + 1, start, s, path, res);
        }
        // cut
        if (isPalindorme(s, start, i)) {
            path.add(s.substring(start, i + 1));
            dfs(i + 1, i + 1, s, path, res);
            path.removeLast();
        }
    }

    private boolean isPalindorme(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
