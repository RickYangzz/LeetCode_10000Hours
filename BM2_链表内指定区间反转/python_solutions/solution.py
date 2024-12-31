class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 
# @param head ListNode类 
# @param m int整型 
# @param n int整型 
# @return ListNode类
#
class Solution:
    def reverseBetween(self , head: ListNode, m: int, n: int) -> ListNode:
        if m>=n: return head

        dummy = ListNode(1)
        dummy.next = head

        pre = dummy
        for _ in range(1, m):
            pre = pre.next
        
        current = pre.next
        for _ in range(0, n-m):
            target = current.next
            current.next = target.next

            target.next = pre.next
            pre.next = target
        
        return dummy.next