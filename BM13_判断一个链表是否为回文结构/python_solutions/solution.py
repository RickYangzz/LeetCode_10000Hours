class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def isPail(self , head: ListNode) -> bool:
        newHead = self.copyList(head)
        tail = self.reverseList(newHead)

        while tail and head:
            if tail.val != head.val:
                return False
            
            tail = tail.next
            head = head.next
        
        return True

    def copyList(self, head: ListNode) -> ListNode:
        newHead = ListNode(head.val)

        current = newHead
        head = head.next

        while head:
            current.next = ListNode(head.val)

            head = head.next
            current = current.next
        
        return newHead
    
    def reverseList(self, head: ListNode) -> ListNode:
        current = head
        pre = None

        while current:
            temp = current.next
            current.next = pre

            pre = current
            current = temp

        return pre