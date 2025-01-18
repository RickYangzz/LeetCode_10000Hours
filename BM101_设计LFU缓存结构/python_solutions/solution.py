from typing import List

class Node:
    def __init__(self, _key: int, _val: int):
        self.key = _key
        self.val = _val
        self.freq = 1

class Solution:
    mainMap: dict[Node]
    frequency: dict[List[Node]]
    minFreq: int
    capacity: int

    def LFU(self , operators: List[List[int]], k: int) -> List[int]:
        self.mainMap: dict[Node] = {}
        self.frequency: dict[List[Node]] = {}
        self.minFreq = 0
        self.capacity = k

        result = []
        for opt in operators:
            if opt[0] == 1: 
                self.set(opt[1], opt[2])
            else:
                result.append(self.get(opt[1]))
        return result 

    def set(self, key: int, value: int) -> None:
        if key not in self.mainMap:
            # 第一次插入
            target = Node(key, value)
            self.insertMainMap(target)
            self.insertFrequency(target)
            self.minFreq = 1
        else:
            # 第n次插入
            target: Node = self.mainMap[key]
            target.val = value
            self.updateFrequency(target)

    def get(self, key: int) -> int:
        if key in self.mainMap:
            target: Node = self.mainMap[key]
            self.updateFrequency(target)
            return target.val

        return -1

    def insertMainMap(self, target: Node) -> None:
        if self.capacity == len(self.mainMap):
            self.deleteLFU()
        
        self.mainMap[target.key] = target
    
    def deleteLFU(self) -> None:
        targetList = self.frequency[self.minFreq]
        target: Node = targetList[0]
        del targetList[0]

        if len(targetList) == 0:
            del self.frequency[self.minFreq]
        
        del self.mainMap[target.key]
     
    def updateFrequency(self, target: Node) -> None:
        # 移除旧的链接
        oldList: List[Node] = self.frequency[target.freq]
        oldList.remove(target)

        if target.freq == self.minFreq and len(oldList) == 0:
            del self.frequency[target.freq]
            self.minFreq += 1
        
        target.freq += 1

        # 建立新的链接
        self.insertFrequency(target)
    
    def insertFrequency(self, target: Node) -> None:
        if target.freq in self.frequency:
            targetList: List[Node] = self.frequency[target.freq]
            targetList.append(target)
        else:
            newList = list()
            newList.append(target)
            self.frequency[target.freq] = newList
        

        