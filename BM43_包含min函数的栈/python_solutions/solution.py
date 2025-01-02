# -*- coding:utf-8 -*-
class Solution:
    stack = []
    min_stack = []

    def push(self, node):
        self.stack.append(node)

        if not self.min_stack or self.min_stack[-1] > node:
            self.min_stack.append(node)
        else:
            current_min = self.min_stack[-1]
            self.min_stack.append(current_min)

    def pop(self):
        self.min_stack.pop()
        return self.stack.pop()

    def top(self):
        return self.stack[-1]

    def min(self):
        return self.min_stack[-1]