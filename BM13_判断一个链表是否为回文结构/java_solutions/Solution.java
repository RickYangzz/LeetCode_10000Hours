package BM13_判断一个链表是否为回文结构.java_solutions;

public class Solution {
    public boolean isPail(ListNode head) {
        ListNode newList = copyList(head);
        ListNode tail = reverseList(newList);

        while (head != null && tail != null) {
            if (head.val == tail.val) {
                head = head.next;
                tail = tail.next;
            } else {
                return false;
            }
        }

        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode pre = null;

        while (current != null) {
            ListNode temp = current.next;
            current.next = pre;

            pre = current;
            current = temp;
        }

        return pre;
    }

    private ListNode copyList(ListNode head) {
        if (head == null)
            return null;

        ListNode newHead = new ListNode(head.val);
        ListNode current = newHead;

        head = head.next;
        while (head != null) {
            current.next = new ListNode(head.val);

            current = current.next;
            head = head.next;
        }

        return newHead;
    }
}