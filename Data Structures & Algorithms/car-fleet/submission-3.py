class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        n = len(position)
        
        cars = sorted(zip(position, speed))

        st = []
        for i, (p, s) in enumerate(cars):
            t = (target - p) / s

            while st and t >= st[-1]:
                st.pop()
            st.append(t)
        return len(st)