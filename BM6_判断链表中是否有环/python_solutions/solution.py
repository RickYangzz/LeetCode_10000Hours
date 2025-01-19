class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

#
# 
# @param head ListNode类 
# @return bool布尔型
#
class Solution:
    def hasCycle(self , head: ListNode) -> bool:
        if not head: return False

        fast = head
        slow = head

        while fast and fast.next and slow:
            fast = fast.next.next
            slow = slow.next

            if fast == slow: return True
        
        return False