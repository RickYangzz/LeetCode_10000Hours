package BM10_两个链表的第一个公共结点.java_solutions;

public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode first = pHead1;
        ListNode second = pHead2;

        while(first != second){
            first = first != null ? first.next : pHead2;

            second = second != null ? second.next : pHead1;
        }

        return first;
    }
}
