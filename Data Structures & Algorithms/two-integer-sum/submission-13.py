class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        val_index = defaultdict(int) # val -> index

        for i, x in enumerate(nums):
            diff = target - x
            if diff in val_index:
                return[val_index[diff], i]
            val_index[x] = i
        