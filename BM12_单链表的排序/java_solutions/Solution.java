package BM12_单链表的排序.java_solutions;

import java.util.*;

public class Solution {
    /**
     * 给定一个节点数为n的无序单链表，对其按升序排序。
     * 
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public ListNode sortInList (ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode left = head;
        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while(fast != null && fast.next != null){
            left = left.next;
            slow = slow.next;
            fast = fast.next.next;
        }

        left.next = null;

        return merge(sortInList(head), sortInList(slow));
    }

    private ListNode merge(ListNode first, ListNode second){
        ListNode result = new ListNode(-1);
        ListNode tail = result;

        while(first != null && second != null){
            if(first.val <= second.val){
                tail.next = first;
                first = first.next;
            } else {
                tail.next = second;
                second = second.next;
            }

            tail = tail.next;
        }

        if(first!=null){
            tail.next = first;
        }

        if(second != null){
            tail.next = second;
        }

        return result.next;
    }
}