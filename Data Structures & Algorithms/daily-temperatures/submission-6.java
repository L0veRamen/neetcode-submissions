class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int [] res = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = 0; i < n;i++){
            int t = temperatures[i];
            while(!st.isEmpty() && t > temperatures[st.peek()]){
                int top = st.pop();
                res[top] = i - top;
            }
            st.push(i);
        }
        return res;
    }
}
