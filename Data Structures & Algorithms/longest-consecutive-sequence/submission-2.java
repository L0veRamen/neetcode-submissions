class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for(int i: nums){
            seen.add(i);
        }
        int maxLength = 0;
        for(int i: nums){
            // only start counting if i is the beginning of the sequence
            if(!seen.contains(i - 1)){
                int current = i;
                int currentLen = 1;
                //extend the sequence as far as possible
                while(seen.contains(current + 1)){
                    current++;
                    currentLen++;
                }
                // track the maximum length of sequence
                maxLength = Math.max(currentLen, maxLength);
            }
        }
        return maxLength;
    }
}
