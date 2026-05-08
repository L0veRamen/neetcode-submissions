class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int can1 = -1, cnt1 = 0;
        int can2 = -1, cnt2 = 0;
        for(int i: nums){
            if(cnt1 > 0 && i == can1){
                cnt1++;
            }else if(cnt2 > 0 && i == can2){
                cnt2++;
            }else if(cnt1 == 0){
                can1 = i;
                cnt1 = 1;
            }else if(cnt2 == 0){
                can2 = i;
                cnt2 = 1;
            }else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for(int i:nums){
            if(i == can1) cnt1++;
            else if(i == can2) cnt2++;
        }

        List<Integer> res = new ArrayList<>();
        int threshold = nums.length / 3;
        if(cnt1 > threshold) res.add(can1);
        if(cnt2 > threshold) res.add(can2);

        return res;


    }
}