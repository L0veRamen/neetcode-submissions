class Solution:
    def simplifyPath(self, path: str) -> str:
        stack = []
        for s in path.split('/'):
            if s == "" or s == ".":
                continue
            if s != "..":
                stack.append(s)
            elif stack: # s == ".."
                stack.pop()
        return '/' + '/'.join(stack)