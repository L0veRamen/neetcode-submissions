class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            // 把 s 排序，作为哈希表的 key
            char[] charArray = s.toCharArray();
            // 排序后相同的字符串分到同一组
            Arrays.sort(charArray);
            String key = new String(charArray);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }
        // 哈希表的所有 value 就是分组结果
        return new ArrayList<>(res.values());
    }
}
