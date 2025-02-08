class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

#
# 
# @param pHead1 ListNode类 
# @param pHead2 ListNode类 
# @return ListNode类
#
class Solution:
    def FindFirstCommonNode(self , pHead1 , pHead2 ):
        a: ListNode = pHead1
        b: ListNode = pHead2

        while a != b:
            a =   a.next if a != None else pHead2
            b = b.next if b != None else pHead1

        return a