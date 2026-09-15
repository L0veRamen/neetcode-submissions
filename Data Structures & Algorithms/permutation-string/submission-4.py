class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        m, n = len(s1), len(s2)
        if m > n:
            return False

        cnt_s1 = [0] * 26
        cnt_t = [0] * 26
        for c in s1:
            cnt_s1[ord(c) - ord('a')] += 1
        
        for i, c in enumerate(s2):
            # 1. enter window
            cnt_t[ord(c) - ord('a')] += 1
            left = i - m + 1
            if left < 0:
                continue
            # 2. find t matches s1 
            if cnt_t == cnt_s1:
                return True
            # 3. exit window
            cnt_t[ord(s2[left]) - ord('a')] -= 1
        return False