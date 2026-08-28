class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        stack = []
        for x in asteroids:
            if x > 0:
                stack.append(x)
                continue
            while stack and stack[-1] > 0:
                top = stack[-1]
                if top <= -x:
                    stack.pop()
                if top >= -x:
                    break
            else:
                stack.append(x)
        return stack