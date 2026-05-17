class Solution:
    def minWindow(self, s: str, t: str) -> str:
        cntS = defaultdict(int)
        cntT = defaultdict(int)
        for t1 in t:
            cntT[t1]+=1

        def check():
            for c in cntT:
                if cntS[c] < cntT[c]:
                    return False
            return True
        res_left, res_right = -1, len(s)
        left = 0

        for right, c in enumerate(s):
            cntS[c] += 1
            while check():
                if right -left < res_right - res_left:
                    res_left, res_right = left, right
                cntS[s[left]] -= 1
                left += 1
        return "" if res_left < 0 else s[res_left: res_right + 1]