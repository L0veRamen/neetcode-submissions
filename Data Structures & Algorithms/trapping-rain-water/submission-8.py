class Solution:
    def trap(self, height: List[int]) -> int:
        res = pre_max = suf_max = 0
        left, right = 0, len(height) - 1
        while left < right:
            pre_max = max(pre_max, height[left])  # 前缀最大值
            suf_max = max(suf_max, height[right])  # 后缀最大值
            if pre_max < suf_max:  # 可以确定 left 处的接水量
                res += pre_max - height[left]
                left += 1  # 搞定了 left，现在问题缩小到 [left+1, right]
            else:  # 可以确定 right 处的接水量
                res += suf_max - height[right]
                right -= 1  # 搞定了 right，现在问题缩小到 [left, right-1]
        return res
