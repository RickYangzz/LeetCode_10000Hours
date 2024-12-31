public class Solution {
    /**
     * 将一个节点数为 size 链表 m 位置到 n 位置之间的区间反转，要求时间复杂度 O(n)，空间复杂度 O(1)。
     * 例如：给出的链表为 1→2→3→4→5→NULL, m=2,n=4, 返回 1→4→3→2→5→NULL.
     * 
     * @param head ListNode类 
     * @param m int整型 
     * @param n int整型 
     * @return ListNode类
     */
    public ListNode reverseBetween (ListNode head, int m, int n) {
        if(m>=n) return head;

        ListNode before = new ListNode(888);
        before.next = head;
        ListNode left = before;
        ListNode current = head;
        int currentPosition = 1;

        ListNode dummy = before; // 标记开始节点
        
        while (currentPosition != m) {
            ListNode right = current.next;

            left = current;
            current = right;

            currentPosition++;
        }

        before = left; // 记录截断的前半部分

        left = null; // 翻转指定局部的节点
        while(currentPosition != n+1) {
            ListNode right = current.next;
            
            // 旋转当前节点的指向
            current.next = left; 

            // 移动到下一个节点
            left = current;
            current = right;

            currentPosition++;
        }
        
        ListNode after = null;
        after = current; // 记录截断的后半部分

        // 开始将旋转过后的链表接回去

        // 接头部
        before.next = left;

        current = left.next;
        while(current != null){
            ListNode right = current.next;

            left = current;
            current = right;
        }

        // 接尾部
        left.next = after;

        return dummy.next;
    }
}