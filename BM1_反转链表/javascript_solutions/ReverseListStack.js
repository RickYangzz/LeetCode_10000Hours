const Stack = require('./Stack.js');

/**
 * Stack-based implementation of linked list reversal
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * @param head ListNode类 
 * @return ListNode类
 */
function ReverseListStack(head) {
    if (head === null) return null;
    
    // Using stack to reverse
    const stack = new Stack();
    let current = head;
    
    // Push all nodes to stack
    while (current !== null) {
        stack.push(current);
        current = current.next;
    }
    
    // Pop to create reversed list
    const newHead = stack.pop();
    current = newHead;
    
    while (!stack.isEmpty()) {
        current.next = stack.pop();
        current = current.next;
    }
    current.next = null;
    
    return newHead;
}

module.exports = {
    ReverseListStack
}; 