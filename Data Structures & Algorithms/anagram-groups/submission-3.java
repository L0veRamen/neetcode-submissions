class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 1. 创建哈希表：key=排序后的字符串（分组标识），value=该组的所有异位词
        Map<String, List<String>> map = new HashMap<>();
        
        // 2. 遍历每个字符串
        for (String s : strs) {
            // 3. 对当前字符串排序，生成分组key
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            // 4. 把当前字符串加入对应分组
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        
        // 5. 把哈希表的所有分组值转成List返回
        return new ArrayList<>(map.values());
    }
}
