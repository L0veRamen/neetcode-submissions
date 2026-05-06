class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        res = 0
        left = 0
        window = set()  # 维护从下标 left 到下标 right 的字符
        for i, val in enumerate(s):
            # 如果窗口内已经包含 c，那么再加入一个 c 会导致窗口内有重复元素
            # 所以要在加入 c 之前，先移出窗口内的 c
            while val in window:  # 窗口内有 c
                window.remove(s[left])
                left += 1  # 缩小窗口
            window.add(val)  # 加入 c
            res = max(res, i - left + 1)  # 更新窗口长度最大值
        return res