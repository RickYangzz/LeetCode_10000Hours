public class SolutionTest {
    public static void main(String[] args) {
        BetterSolution solution = new BetterSolution();

        // Test Case 1: Basic test case where `m` and `n` are within the list bounds
        ListNode head1 = ListNode.buildList(new int[]{1, 2, 3, 4, 5});
        head1 = solution.reverseBetween(head1, 2, 4);
        String result1 = ListNode.printList(head1);
        String expected1 = "1 4 3 2 5";
        System.out.println("Test Case 1: " + (result1.equals(expected1) ? "passed" : "failed"));

        // Test Case 2: No reversal, `m` equals `n`
        ListNode head2 = ListNode.buildList(new int[]{1, 2, 3, 4, 5});
        head2 = solution.reverseBetween(head2, 3, 3);
        String result2 = ListNode.printList(head2);
        String expected2 = "1 2 3 4 5";
        System.out.println("Test Case 2: " + (result2.equals(expected2) ? "passed" : "failed"));

        // Test Case 3: Reversal includes the entire list
        ListNode head3 = ListNode.buildList(new int[]{1, 2, 3, 4, 5});
        head3 = solution.reverseBetween(head3, 1, 5);
        String result3 = ListNode.printList(head3);
        String expected3 = "5 4 3 2 1";
        System.out.println("Test Case 3: " + (result3.equals(expected3) ? "passed" : "failed"));

        // Test Case 4: Reversal with only two elements in the sublist
        ListNode head4 = ListNode.buildList(new int[]{1, 2, 3, 4, 5});
        head4 = solution.reverseBetween(head4, 3, 4);
        String result4 = ListNode.printList(head4);
        String expected4 = "1 2 4 3 5";
        System.out.println("Test Case 4: " + (result4.equals(expected4) ? "passed" : "failed"));

        // Test Case 5: Reversal starting from the head of the list
        ListNode head5 = ListNode.buildList(new int[]{1, 2, 3, 4, 5});
        head5 = solution.reverseBetween(head5, 1, 3);
        String result5 = ListNode.printList(head5);
        String expected5 = "3 2 1 4 5";
        System.out.println("Test Case 5: " + (result5.equals(expected5) ? "passed" : "failed"));

        // Test Case 6: Edge case with a single element
        ListNode head6 = ListNode.buildList(new int[]{1});
        head6 = solution.reverseBetween(head6, 1, 1);
        String result6 = ListNode.printList(head6);
        String expected6 = "1";
        System.out.println("Test Case 6: " + (result6.equals(expected6) ? "passed" : "failed"));

        // Test Case 7: Reversing the list with only two elements
        ListNode head7 = ListNode.buildList(new int[]{1, 2});
        head7 = solution.reverseBetween(head7, 1, 2);
        String result7 = ListNode.printList(head7);
        String expected7 = "2 1";
        System.out.println("Test Case 7: " + (result7.equals(expected7) ? "passed" : "failed"));

        // Test Case 8: Empty list
        ListNode head9 = null;
        head9 = solution.reverseBetween(head9, 1, 1);
        String result9 = ListNode.printList(head9);
        String expected9 = "";
        System.out.println("Test Case 8: " + (result9.equals(expected9) ? "passed" : "failed"));
    }
}
