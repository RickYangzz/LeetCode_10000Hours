class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.pre = None
        self.next = None

class Solution:
    def __init__(self, capacity: int):
        self.size = capacity
        self.map = {}

        self.head = Node(-1, -1)
        self.trail = Node(-1, -1)
        self.head.next = self.trail
        self.trail.pre = self.head
    
    def get(self, key: int) -> int:
        if key in self.map:
            target = self.map[key]
            self.moveToHead(target)
            return target.value
        
        return -1
    
    def set(self, key: int, value: int) -> None:
        if key in self.map:
            target = self.map[key]
            target.value = value
            self.moveToHead(target)
        else:
            if self.size == 0:
                self.removeTrail()
            else:
                self.size -= 1
            
            target = Node(key, value)
            self.map[key] = target
            self.insertToHead(target)
    
    # 将 已经存在的 target node 移动到链表头部
    def moveToHead(self, target: Node) -> None:
        # 切断左右连接
        target.pre.next = target.next
        target.next.pre = target.pre

        self.insertToHead(target)
    
    # 将 target node 插入到链表头部
    def insertToHead(self, target: Node)-> None:
        target.pre = self.head
        target.next = self.head.next

        self.head.next.pre = target
        self.head.next = target

    # 移除掉 链表尾部
    def removeTrail(self)->None:
        lastNode = self.trail.pre
        lastNode.pre.next = self.trail
        self.trail.pre = lastNode.pre

        # 删除 map 中对应的项
        del self.map[lastNode.key]
