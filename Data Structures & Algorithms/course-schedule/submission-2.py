class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        g = [[] for _ in range(numCourses)]

        for a, b in prerequisites:
            g[b].append(a)
        
        colors = [0] * numCourses

        def dfs(i:int) -> bool:
            colors[i] = 1 # current visit 
            for nxt in g[i]:
                if colors[nxt] == 1 or colors[nxt] == 0 and dfs(nxt):
                    return True
            colors[i] = 2 # mark complete visit
            return False

        for i, c in enumerate(colors):
            if c == 0 and dfs(i):
                return False
        return True