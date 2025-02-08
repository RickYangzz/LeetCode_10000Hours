import java.util.*;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        if(head1 == null) return head2;
        if(head2 == null) return head1;

        head1 = reverseLinkedList(head1);
        head2 = reverseLinkedList(head2);

        ListNode result = new ListNode(-1);
        ListNode tail = result;
        int carry = 0;

        while(head1 != null || head2 != null || carry != 0) {
            int a = head1 != null ? head1.val : 0;
            int b = head2 != null ? head2.val : 0;
            int value = a + b + carry;

            carry = value / 10;
            value = value % 10;
            tail.next = new ListNode(value);

            head1 = head1 != null ? head1.next : null;
            head2 = head2 != null ? head2.next : null;
            tail = tail.next;
        }

        return reverseLinkedList(result.next);
    }

    private ListNode reverseLinkedList(ListNode head){
        ListNode current = head;
        ListNode pre = null;
        
        while(current != null){
            ListNode temp = current.next;

            current.next = pre;

            pre = current;
            current = temp;
        }

        return pre;
    }
}