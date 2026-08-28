class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for token in tokens:
            if len(token) > 1 or token[0].isdigit():
                stack.append(int(token))
                continue
            x = stack.pop()
            if token == '+':
                stack[-1] += x
            elif token == '-':
                stack[-1] -= x
            elif token == '*':
                stack[-1] *= x 
            else:
                y = stack[-1]
                stack[-1] = y // x if y * x >= 0 else -(-y // x)
        return stack[0]