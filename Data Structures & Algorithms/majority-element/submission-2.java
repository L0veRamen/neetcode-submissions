class Solution {
    public int majorityElement(int[] nums) {
        int res = 0;
        int count = 0;
        for(int i: nums){
            if(count == 0){
                res = i;
                count = 1;
            }else{
                count += i == res ? 1: -1; 
            }
        }
        return res;
    }
}