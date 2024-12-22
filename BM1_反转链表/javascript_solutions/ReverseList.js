/**
 * In-place implementation of linked list reversal
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * @param head ListNode类 
 * @return ListNode类
 */
function ReverseList(head) {
    if (head === null) return null;
    let pre = null;
    while (head !== null) { 
        let next = head.next;
        head.next = pre;
        pre = head;
        head = next;
    }
    return pre;
}

module.exports = {
    ReverseList
};