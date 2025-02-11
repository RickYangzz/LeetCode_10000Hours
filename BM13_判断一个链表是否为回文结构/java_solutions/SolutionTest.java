package BM13_判断一个链表是否为回文结构.java_solutions;

public class SolutionTest {
    public static void main(String[] args) {
        // Test case 6: A non-palindrome list with an extra 1 at the end
        ListNode test6 = createList(new int[]{1, 2, 3, 4, 5, 6, 1});
        System.out.println("Test 6 (Expected: false): " + new Solution().isPail(test6));

        // Test case 1: A palindrome list
        ListNode test1 = createList(new int[]{1, 2, 3, 2, 1});
        System.out.println("Test 1 (Expected: true): " + new Solution().isPail(test1));

        // Test case 2: A non-palindrome list
        ListNode test2 = createList(new int[]{1, 2, 3, 4, 5});
        System.out.println("Test 2 (Expected: false): " + new Solution().isPail(test2));

        // Test case 3: A single-node list (always a palindrome)
        ListNode test3 = createList(new int[]{1});
        System.out.println("Test 3 (Expected: true): " + new Solution().isPail(test3));

        // Test case 4: An empty list (always a palindrome)
        ListNode test4 = null;
        System.out.println("Test 4 (Expected: true): " + new Solution().isPail(test4));

        // Test case 5: A palindrome list with even length
        ListNode test5 = createList(new int[]{1, 2, 3, 3, 2, 1});
        System.out.println("Test 5 (Expected: true): " + new Solution().isPail(test5));

        

        // Test case 7: A palindrome list with repeated elements
        ListNode test7 = createList(new int[]{5, 5, 5, 5, 5});
        System.out.println("Test 7 (Expected: true): " + new Solution().isPail(test7));
    }

    // Helper function to create a ListNode from an array of integers
    private static ListNode createList(int[] values) {
        ListNode head = null;
        ListNode current = null;
        for (int value : values) {
            if (head == null) {
                head = new ListNode(value);
                current = head;
            } else {
                current.next = new ListNode(value);
                current = current.next;
            }
        }
        return head;
    }
}
