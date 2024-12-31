public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode buildList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummy.next;
    }

    public static String printList(ListNode head) {
        StringBuilder result = new StringBuilder();
        while (head != null) {
            result.append(head.val).append(" ");
            head = head.next;
        }
        return result.toString().trim();
    }
}

