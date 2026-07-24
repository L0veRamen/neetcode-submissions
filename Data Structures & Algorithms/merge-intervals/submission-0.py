class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key=lambda p: p[0])  # 按照左端点从小到大排序

        res = []
        for p in intervals:
            if res and p[0] <= res[-1][1]: #左端点在合并区间内，可以合并
                res[-1][1] = max(res[-1][1], p[1])
            else:
                res.append(p)
        return res
