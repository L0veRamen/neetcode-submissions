class MinStack:

    def __init__(self):
        self.stack = [(0, float('inf'))] # [val, min value]

    def push(self, val: int) -> None:
        self.stack.append((val, min(val, self.stack[-1][1])))

    def pop(self) -> None:
        self.stack.pop()

    def top(self) -> int:
        return self.stack[-1][0]

    def getMin(self) -> int:
        return self.stack[-1][1]
