class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        res = hp = 0

        for num in nums:
            if hp == 0:
                res, hp = num, 1
            else:
                hp += (1 if num == res else -1)
        return res