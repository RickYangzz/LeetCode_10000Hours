class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


# 
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 
# @param pHead1 ListNode类 
# @param pHead2 ListNode类 
# @return ListNode类
#
class Solution:
    def Merge(self , pHead1: ListNode, pHead2: ListNode) -> ListNode:
        result = ListNode(-1)
        current = result

        while pHead1 and pHead2:
            if pHead1.val <= pHead2.val:
                current.next = pHead1
                pHead1 = pHead1.next
            else:
                current.next = pHead2
                pHead2 = pHead2.next
            
            current = current.next
        
        current.next = pHead1 or pHead2

        return result.next