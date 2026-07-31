class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int [] res = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = n - 1; i >= 0; i--){
            int t = temperatures[i];
            while(!st.isEmpty() && t >= temperatures[st.peek()]){
               st.pop();
            }
            if(!st.isEmpty()){
                res[i] = st.peek() - i; 
            }
            st.push(i);
        }
        return res;
    }
}
