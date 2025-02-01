# -*- coding:utf-8 -*-
from bisect import insort

class Solution:
    def __init__(self):
        self.store = []  # 初始化存储的有序列表

    def Insert(self, num):
        """
        插入一个数到有序列表中，保持有序
        """
        # 使用 bisect.insort 来实现有序插入 
        insort(self.store, num)
        
    def GetMedian(self):
        size = len(self.store)

        if size%2 == 0:
            first = self.store[size//2]
            second = self.store[size//2 -1]

            return (first + second) / 2
        else:
            return self.store[(size//2)]
