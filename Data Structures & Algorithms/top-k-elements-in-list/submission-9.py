class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = defaultdict(int)
        freq = [[] for _ in range(len(nums) + 1)]

        for num in nums:
            count[num] += 1
        
        for x, c in count.items():
            freq[c].append(x)

        res = []
        for f in reversed(freq):
            res += f
            if len(res) == k:
                return res