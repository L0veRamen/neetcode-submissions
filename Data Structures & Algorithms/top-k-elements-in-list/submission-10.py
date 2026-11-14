class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        cnt = defaultdict(int)
        for num in nums:
            cnt[num] += 1
        
        heap = []
        for num, count in cnt.items():
            heapq.heappush(heap, (count, num))
            if len(heap) > k:
                heapq.heappop(heap)
        
        res = []
        for count, num in heap:
            res.append(num)
        return res