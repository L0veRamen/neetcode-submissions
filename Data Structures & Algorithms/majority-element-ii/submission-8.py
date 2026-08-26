class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        k = 3
        m = k -1
        candidates = [0] * m
        counts = [0] * m
        occupied = [False] * m

        # Phase 1: candidate selection
        for num in nums:
            matched = False
            for i in range(m):
                if occupied[i] and candidates[i] == num:
                    counts[i] += 1
                    matched = True
                    break
            if matched:
                continue

            placed = False
            for i in range(m):
                if not occupied[i]:
                    occupied[i] = True
                    candidates[i] = num
                    counts[i] = 1
                    placed = True
                    break
            if placed:
                continue

            for i in range(m):
                counts[i] -= 1
                if counts[i] == 0:
                    occupied[i] = False

        # Phase 2: verification pass
        final_counts = [0] * m
        for num in nums:
            for i in range(m):
                if occupied[i] and candidates[i] == num:
                    final_counts[i] += 1
                    break

        n = len(nums)
        return [candidates[i] for i in range(m) if occupied[i] and final_counts[i] > n // k]

        