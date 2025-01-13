package BM5_合并k个已排序的链表.java_solutions;

import java.util.*;

public class HeapSolution {
    /**
     * 合并 k 个升序的链表并将结果作为一个升序的链表返回其头节点。
     *
     *
     * @param lists ListNode类ArrayList
     * @return ListNode类
     */
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(
            (n1, n2) -> n1.val - n2.val
        );

        for (ListNode listNode : lists) {
            if(listNode != null) pq.add(listNode);
        }

        ListNode res = new ListNode(-1);
        ListNode head = res;

        while (pq.size() > 0) {
            ListNode min = pq.poll();
            
            head.next = min;
            head = min;

            if (min.next != null) pq.add(min.next);
        }

        return res.next;
    }
}