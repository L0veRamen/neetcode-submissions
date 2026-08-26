class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] res = new int[2 * nums.length];
        int idx = 0;
        for(int i = 0; i < 2; i++){
            for(int n: nums){
                res[idx++] = n;
            }
        }
        return res;
    }
}