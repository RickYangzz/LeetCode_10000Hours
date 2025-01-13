package BM5_合并k个已排序的链表.java_solutions;

import java.util.List;

public class MergeSolution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if(lists.size() == 0) return null;
        if(lists.size() == 1) return lists.get(0);

        int middle = lists.size() / 2;

        ListNode left = mergeKLists(lists.subList(0, middle));
        ListNode right = mergeKLists(lists.subList(middle, lists.size()));

        ListNode res = new ListNode(-1);
        ListNode head = res;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                head.next = left;
                head = head.next;

                left = left.next;
            } else {
                head.next = right;
                head = head.next;

                right = right.next;
            }
        }

        if (left != null) {
            head.next = left;
        }

        if (right != null) {
            head.next = right;
        }

        return res.next;
    }
}
