class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 
# @param head ListNode类 
# @return ListNode类
#
class Solution:
    def ReverseList(self , head: ListNode) -> ListNode:
        # Handle empty list or single node case
        if not head or not head.next:
            return head;
        
        # Initialize pointers
        pre = None;        # Previous node pointer
        current = head;    # Current node pointer
        
        # Traverse the list and reverse links
        while current:
            next = current.next;      # Store next node
            current.next = pre;       # Reverse the link
            pre = current;            # Move pre one step forward
            current = next;           # Move current one step forward
            
        # Return new head (original tail)
        return pre;

