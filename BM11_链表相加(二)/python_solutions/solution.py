class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 
# @param head1 ListNode类 
# @param head2 ListNode类 
# @return ListNode类
#
class Solution:
    def addInList(self , head1: ListNode, head2: ListNode) -> ListNode:
        if not head1: return head2
        if not head2: return head1

        head1 = self.reverseLinkedList(head1)
        head2 = self.reverseLinkedList(head2)

        result = ListNode(-1)
        tail = result
        carry = 0

        while head1 or head2 or carry > 0:
            a = head1.val if head1 else 0
            b = head2.val if head2 else 0
            value = a + b + carry

            carry = value // 10
            value = value % 10
            tail.next = ListNode(value)

            head1 = head1.next if head1 else None
            head2 = head2.next if head2 else None
            tail = tail.next
        
        return self.reverseLinkedList(result.next)
    
    
    def reverseLinkedList(self, head: ListNode) -> ListNode:
        current = head
        pre = None

        while current:
            temp = current.next
            current.next = pre

            pre = current
            current = temp

        return pre