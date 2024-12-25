# -*- coding:utf-8 -*-
class Solution:
    def __init__(self):
        self.push_stack = []
        self.pop_stack = []

    def push(self, node):
        self.push_stack.append(node)

    def pop(self):
        if not self.pop_stack:
            while self.push_stack:
                self.pop_stack.append(self.push_stack.pop())
        return self.pop_stack.pop()