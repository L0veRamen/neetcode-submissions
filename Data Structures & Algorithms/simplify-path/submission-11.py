class Solution:
    def simplifyPath(self, path: str) -> str:
        stack = []
        for p in path.split('/'):
            if p == "" or p == ".": 
                continue
            if p != "..":
                stack.append(p)
            elif stack:
                stack.pop()
        return '/' + '/'.join(stack)