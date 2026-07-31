class Solution:
    def isValid(self, s: str) -> bool:
        if len(s) % 2 != 0:
            return False 
        stack = []
        close = { ")": "(", "]":"[", "}":"{"}
        for c in s:
            if c in close:
                if stack and stack[-1] == close.get(c):
                    stack.pop()
                else:
                    return False
            else:
                stack.append(c)
        return True if not stack else False