class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        // Step 1: pair and sort by position descending (front of road first)
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> b[0] - a[0]); // descending by position

        // Step 2: monotonic stack of arrival times
        Deque<Double> stack = new ArrayDeque<>();

        for (int[] car : cars) {
            double time = (double) (target - car[0]) / car[1];

            // Step 3: only a strictly SLOWER car forms a new fleet
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
            // else: this car catches up → merges, do nothing
        }

        // Step 4: each entry in stack = one fleet
        return stack.size();
    }
}
