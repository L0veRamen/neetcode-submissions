class Solution {
    public String foreignDictionary(String[] words) {
      // Step 1: Initialize graph structures
        // - Track all unique characters
        // - indegree[c] = number of characters that must come before c
        // - graph: adjacency list for "comes before" relationship
        
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        
        // Initialize all characters with indegree 0
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }
        
        // Step 2: Build edges by comparing adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            
            // Edge case: "abc" before "ab" is invalid
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            
            // Find first differing character
            int minLen = Math.min(word1.length(), word2.length());
            for (int j = 0; j < minLen; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                
                if (c1 != c2) {
                    // c1 comes before c2
                    // Only add edge if not already present (avoid duplicate indegree count)
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        indegree.put(c2, indegree.get(c2) + 1);
                    }
                    break; // Only first difference matters!
                }
            }
        }
        
        // Step 3: Topological Sort (Kahn's Algorithm)
        Queue<Character> queue = new LinkedList<>();
        
        // Start with characters that have no prerequisites
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }
        
        StringBuilder result = new StringBuilder();
        
        while (!queue.isEmpty()) {
            char curr = queue.poll();
            result.append(curr);
            
            // "Remove" this character and update neighbors
            for (char neighbor : graph.get(curr)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // Step 4: Check for cycle
        // If we couldn't process all characters, there's a cycle
        if (result.length() != indegree.size()) {
            return "";
        }
        
        return result.toString();
    }
}
