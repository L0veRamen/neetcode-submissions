class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        int[] st = new int[n];
        int top = -1;
        for(int i = 0; i < n;i++){
            int t = temperatures[i];
            while(top >= 0 && t > temperatures[st[top]]){
                int j = st[top--];
                res[j] = i - j;
            }
            st[++top] = i;
        }
        return res;
    }
}
