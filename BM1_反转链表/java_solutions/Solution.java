package java_solutions;

public class Solution {
    private ListNode next = null;  // Temporary storage for next node during reversal

    /**
     * Reverses a singly linked list
     * Example: 1->2->3 becomes 3->2->1
     * 
     * @param head The head node of the original linked list
     * @return The head node of the reversed linked list
     */
    public ListNode ReverseList(ListNode head) {
        if(head == null) return null;  // Handle empty list case

        return this.reverseCurrentNode(null, head);
    }

    private ListNode reverseCurrentNode(ListNode pre, ListNode current){
        this.next = current.next;      // Save reference to next node
        current.next = pre;            // Reverse the link

        if (this.next == null) {       // If we've reached the end of the list
            return current;            // Return the new head (original tail)
        } else {
            return reverseCurrentNode(current, this.next);  // Process next node
        }
    }
}
