class TimeMap:

    def __init__(self):
        self.store = defaultdict(list)  # key -> [(timestamp, value), ...]

    def set(self, key: str, value: str, timestamp: int) -> None:
        self.store[key].append((timestamp, value))

    def get(self, key: str, timestamp: int) -> str:
        if key not in self.store:
            return ""
        records = self.store[key]
        res = ""
        l, r = -1, len(records)
        while l + 1 < r:
            mid = (l + r) // 2
            if records[mid][0] <= timestamp:
                res = records[mid][1]
                l = mid
            else:
                r = mid
        return res

        
