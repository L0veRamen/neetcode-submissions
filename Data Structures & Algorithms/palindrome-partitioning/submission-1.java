class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(0, s, path, res);
        return res;
    }

    private void dfs(int i, String s, List<String> path, List<List<String>> res) {
        if (i == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (isPalindorme(s, i, j)) {
                path.add(s.substring(i, j + 1));
                dfs(j + 1, s, path, res);
                path.removeLast();
            }
        }
    }

    private boolean isPalindorme(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
