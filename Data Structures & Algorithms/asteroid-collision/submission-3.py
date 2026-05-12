class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        stack = []
        for a in asteroids:
            destroyed = False
            
            while stack and stack[-1] > 0 and a < 0:
                top = stack[-1]
                cur = abs(a)

                if top < cur:
                    stack.pop() # top explodes, current survive
                elif top == cur: # both explodes
                    stack.pop()
                    destroyed = True
                    break
                else:
                    destroyed = True # current explodes
                    break
            if not destroyed:
                stack.append(a)
        return stack
