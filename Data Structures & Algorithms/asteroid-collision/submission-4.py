class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        stack = []
        for a in asteroids:
            if a > 0:
                stack.append(a)
            else:
                # a < 0
                while stack and stack[-1] > 0:
                    diff = a + stack[-1]
                    if diff < 0: # top is smaller, it explodes
                        stack.pop()
                        continue
                    elif diff == 0: # both explodes
                        stack.pop()
                        break
                    else:
                        # diff > 0 current asteroid is destroyed
                        break
                else:
                    # no collision with positive asteroids
                    stack.append(a)
        return stack