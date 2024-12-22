class Stack {
    constructor() {
        this.items = [];
    }

    // Push element to stack
    push(element) {
        this.items.push(element);
    }

    // Remove and return top element
    pop() {
        if (this.isEmpty()) return null;
        return this.items.pop();
    }

    // Return top element without removing
    peek() {
        if (this.isEmpty()) return null;
        return this.items[this.items.length - 1];
    }

    // Check if stack is empty
    isEmpty() {
        return this.items.length === 0;
    }

    // Get size of stack
    size() {
        return this.items.length;
    }

    // Clear the stack
    clear() {
        this.items = [];
    }
}

module.exports = Stack; 