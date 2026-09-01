class FreqStack:

    def __init__(self):
        self.stack = []
        self.count = defaultdict(int)

    def push(self, val: int) -> None:
        if self.count[val] == len(self.stack):
            self.stack.append([val])
        else:
            self.stack[self.count[val]].append(val)
        self.count[val] += 1
        

    def pop(self) -> int:
        val = self.stack[-1].pop()
        if not self.stack[-1]:
            self.stack.pop()
        self.count[val] -= 1
        return val


# Your FreqStack object will be instantiated and called as such:
# obj = FreqStack()
# obj.push(val)
# param_2 = obj.pop()