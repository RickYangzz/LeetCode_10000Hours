from typing import List

class Solution:
    def mergeKLists(self , lists: List[ListNode]) -> ListNode:
        size = len(lists)

        if size == 0: return None
        if size == 1: return lists[0]

        middle = size // 2
        left = self.mergeKLists(lists[:middle])
        right = self.mergeKLists(lists[middle:])
    
        res = ListNode(-1)
        head = res

        while left and right:
            if left.val <= right.val:
                head.next = left
                head = head.next
                left = left.next
            else:
                head.next = right
                head = head.next
                right = right.next
        
        if left:
            head.next = left
        
        if right:
            head.next = right
        
        return res.next