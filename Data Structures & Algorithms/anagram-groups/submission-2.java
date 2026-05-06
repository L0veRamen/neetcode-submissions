class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Key: sorted string → Value: all anagrams sharing that key
        Map<String, List<String>> m = new HashMap<>();
        for(String s: strs){
            char[]sortedS = s.toCharArray();
            Arrays.sort(sortedS);
            String key = new String(sortedS);

            // Group original word under its canonical key
            m.putIfAbsent(key, new ArrayList<>());
            m.get(key).add(s);
        }
        return new ArrayList<>(m.values());
    }
}
