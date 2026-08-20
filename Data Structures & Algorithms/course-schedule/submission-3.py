class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        g = [[] for _ in range(numCourses)]
        in_degree = [0] * numCourses
        q = deque()

        for a, b in prerequisites:
            g[b].append(a)
            in_degree[a] += 1
        
        for i in range(numCourses):
            if in_degree[i] == 0:
                q.append(i)
        
        processed = 0
        while q:
            processed += 1
            cur = q.popleft()
            for nxt in g[cur]:
                in_degree[nxt] -= 1
                if in_degree[nxt] == 0:
                    q.append(nxt)
        return processed == numCourses

        