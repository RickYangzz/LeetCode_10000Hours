class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def deleteDuplicates(self , head: ListNode) -> ListNode:
        if not head or not head.next: return head

        res = ListNode(-1)
        res.next = head
        current = res

        while current.next  and current.next.next:
            if(current.next.val == current.next.next.val):
                temp = current.next.val
                while current.next and current.next.val == temp:
                    current.next = current.next.next
            else:
                current = current.next
        
        return res.next
            