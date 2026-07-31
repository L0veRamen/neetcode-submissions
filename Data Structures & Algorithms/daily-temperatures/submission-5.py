class Solution:
    def dailyTemperatures(self, temps: List[int]) -> List[int]:
        n = len(temps)
        res = [0] * n
        st = []
        for i in range(n- 1, -1, -1):
            t = temps[i]
            while st and t >= temps[st[-1]]:
                st.pop() 
            if st:
                res[i] = st[-1] - i
            st.append(i)
        return res