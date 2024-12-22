package java_solutions;

public class SolutionTest {
    /**
     * Helper method to create a linked list from an array of integers
     */
    private static ListNode createList(int[] values) {
        if (values == null || values.length == 0) return null;
        
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    /**
     * Helper method to print a linked list
     */
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Normal case (1->2->3)
        System.out.println("Test Case 1: Normal list");
        ListNode test1 = createList(new int[]{1, 2, 3});
        System.out.print("Original: ");
        printList(test1);
        System.out.print("Reversed: ");
        printList(solution.ReverseList(test1));

        // Test Case 2: Single node
        System.out.println("\nTest Case 2: Single node");
        ListNode test2 = createList(new int[]{1});
        System.out.print("Original: ");
        printList(test2);
        System.out.print("Reversed: ");
        printList(solution.ReverseList(test2));

        // Test Case 3: Empty list
        System.out.println("\nTest Case 3: Empty list");
        ListNode test3 = null;
        System.out.print("Original: ");
        printList(test3);
        System.out.print("Reversed: ");
        printList(solution.ReverseList(test3));

        // Test Case 4: Longer list
        System.out.println("\nTest Case 4: Longer list");
        ListNode test4 = createList(new int[]{1, 2, 3, 4, 5, 6});
        System.out.print("Original: ");
        printList(test4);
        System.out.print("Reversed: ");
        printList(solution.ReverseList(test4));
    }
} 