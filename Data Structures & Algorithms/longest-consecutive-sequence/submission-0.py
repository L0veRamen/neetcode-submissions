class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        num_set = set(nums)
        ans = 0
        for i in num_set:
            if i - 1 in num_set:
                continue
            # i is start point
            j = i + 1
            while j in num_set:
                j += 1
            ans = max( ans, j - i) # from i to j, total length is j-i
        return ans