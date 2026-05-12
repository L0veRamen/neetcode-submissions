class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int asteroid : asteroids) {
            boolean destroyed = false;

            // Collision only when: top is positive, current is negative
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                int top = stack.peek();
                int cur = Math.abs(asteroid);

                if (top < cur) {
                    // Stack top explodes, current survives → keep looping
                    stack.pop();
                } else if (top == cur) {
                    // Both explode
                    stack.pop();
                    destroyed = true;
                    break;
                } else {
                    // Current explodes, stack top survives
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        // Stack is in reverse order — convert to array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}