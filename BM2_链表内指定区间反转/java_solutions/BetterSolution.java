public class BetterSolution {
    public ListNode reverseBetween (ListNode head, int m, int n) {
        if(m >= n) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }

        ListNode start = pre.next;
        for (int i = 0; i < n - m; i++) {
            ListNode target = start.next;
            start.next = target.next;

            // 将目标元素移动到头部
            target.next = pre.next;
            pre.next = target;
        }

        return dummy.next;
    }
}
