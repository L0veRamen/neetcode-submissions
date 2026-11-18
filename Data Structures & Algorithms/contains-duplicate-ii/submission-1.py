class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        st = set()
        for i, x in enumerate(nums):
            if x in st:
                return True
            st.add(x)
            if i >= k:
                st.remove(nums[i - k])
        return False

