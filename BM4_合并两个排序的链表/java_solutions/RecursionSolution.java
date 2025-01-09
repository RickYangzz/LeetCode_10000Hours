package BM4_合并两个排序的链表.java_solutions;

/**
 * 输入两个递增的链表，单个链表的长度为n，合并这两个链表并使新链表中的节点仍然是递增排序的。
 */
public class RecursionSolution {
    public ListNode Merge(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null)
            return pHead2;
        if (pHead2 == null)
            return pHead1;

        if (pHead1.val <= pHead2.val) {
            pHead1.next = Merge(pHead1.next, pHead2);
            return pHead1;
        } else {
            pHead2.next = Merge(pHead1, pHead2.next);
            return pHead2;
        }
    }
}
