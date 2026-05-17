class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        m = len(s1)
        if m > len(s2):
            return False
        
        cnt_s1 = defaultdict(int)
        cnt_s2 = defaultdict(int)

        for s in s1:
            cnt_s1[s] += 1
        for i, c in enumerate(s2):
            cnt_s2[c] += 1
            if i < m - 1:
                continue
            if cnt_s2 == cnt_s1:
                return True
            left = s2[i - m + 1]
            cnt_s2[left] -= 1
            if cnt_s2[left] == 0:
                del cnt_s2[left]
        return False
