class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def sortInList(self , head: ListNode) -> ListNode:
        if not head or not head.next: return head

        left = head
        mid = head.next
        right = head.next.next

        while right and right.next:
            left = left.next
            mid = mid.next
            right = right.next.next

        left.next = None
        return self.merge(self.sortInList(head), self.sortInList(mid))

    def merge(self, first: ListNode, second: ListNode) -> ListNode:
        result = ListNode(-1)
        tail = result

        while first and second:
            if first.val <= second.val:
                tail.next = first
                first = first.next
            else:
                tail.next = second
                second = second.next
                
            tail = tail.next
        
        if first:
            tail.next = first

        if second:
            tail.next = second

        return result.next