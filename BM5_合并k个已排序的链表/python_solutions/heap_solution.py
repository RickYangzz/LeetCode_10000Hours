from queue import PriorityQueue

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def mergeKLists(self , lists: List[ListNode]) -> ListNode:
        min_heap = PriorityQueue()
        for idx in range(len(lists)):
            if lists[idx] != None:
                min_heap.put((lists[idx].val, idx))
                lists[idx] = lists[idx].next
    
        res = ListNode(-1)
        head = res
        
        while not min_heap.empty():
            val, idx = min_heap.get()

            head.next = ListNode(val)
            head = head.next

            if lists[idx] != None:
                min_heap.put((lists[idx].val, idx))
                lists[idx] = lists[idx].next
        
        return res.next