class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] preMax = new int[n]; // [0, i] max height
        int[] sufMax = new int[n]; // [i. n-1] max height
        preMax[0] = height[0];
        sufMax[n-1] = height[n - 1];
        for(int i = 1; i < n; i++){
            preMax[i] = Math.max(preMax[i - 1], height[i]);
        }

        for(int i = n - 2; i >= 0;i--){
            sufMax[i] = Math.max(sufMax[i + 1], height[i]);
        }
        int res = 0;
        for(int i = 0; i < n ;i++){
            res += Math.min(preMax[i], sufMax[i]) - height[i];
        }
        return res;


    }
}
