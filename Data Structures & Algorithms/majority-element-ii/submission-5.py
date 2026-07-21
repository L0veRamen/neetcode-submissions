class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        count = defaultdict(int)
        for n in nums:
            count[n] += 1
        res = []
        for key in count:
            if count[key] > len(nums) // 3:
                res.append(key)
        return res