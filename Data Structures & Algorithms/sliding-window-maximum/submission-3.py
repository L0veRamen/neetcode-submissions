class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        q = deque()
        res = [0] * (len(nums) - k + 1) # window size
        for i, x in enumerate(nums):
            # 1 enter window 
            while q and nums[q[-1]] <= x:
                q.pop() 
            q.append(i) # store index to find if front queue is leaving out of window

            # 2 out window 
            left = i - k + 1
            if q[0] < left:
                q.popleft()

            # 3 update res
            if left >= 0:
                res[left] = nums[q[0]]

        return res