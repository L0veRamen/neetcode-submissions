class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        # build dict: position -> arrival time
        time_map = {
            pos: (target - pos)/ spd for pos, spd in zip(position, speed)
        }

        fleets = 0;
        prev_time = 0;

        # Iterate by descending position (front of road first)
        for pos in sorted(time_map.keys(), reverse=True):
            time = time_map[pos]
            if time > prev_time:
                prev_time = time
                fleets += 1
        return fleets