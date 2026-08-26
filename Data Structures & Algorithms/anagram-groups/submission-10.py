class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        map = defaultdict(list)
        for s in strs:
            sorted_key = "".join(sorted(s))
            map[sorted_key].append(s)
        return list(map.values())