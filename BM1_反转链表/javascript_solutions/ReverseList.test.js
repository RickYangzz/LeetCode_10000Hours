const { ReverseList } = require('./ReverseList.js');
const { ReverseListStack } = require('./ReverseListStack.js');

function ListNode(x){
    this.val = x;
    this.next = null;
}

// Helper function to create linked list from array
function createList(arr) {
    if (!arr.length) return null;
    let head = new ListNode(arr[0]);
    let current = head;
    for (let i = 1; i < arr.length; i++) {
        current.next = new ListNode(arr[i]);
        current = current.next;
    }
    return head;
}

// Helper function to convert linked list to array for testing
function listToArray(head) {
    let result = [];
    while (head) {
        result.push(head.val);
        head = head.next;
    }
    return result;
}

function runTests(reverseFunction, solutionName) {
    console.log(`\nTesting ${solutionName}:`);
    
    // Test Case 1: Normal case with multiple nodes
    let test1 = createList([1, 2, 3, 4, 5]);
    console.log('Test 1 - Multiple nodes:');
    console.log('Input:', listToArray(test1));
    console.log('Output:', listToArray(reverseFunction(test1)));
    console.log('Expected: [5, 4, 3, 2, 1]\n');

    // Test Case 2: Single node
    let test2 = createList([1]);
    console.log('Test 2 - Single node:');
    console.log('Input:', listToArray(test2));
    console.log('Output:', listToArray(reverseFunction(test2)));
    console.log('Expected: [1]\n');

    // Test Case 3: Empty list
    let test3 = null;
    console.log('Test 3 - Empty list:');
    console.log('Input: null');
    console.log('Output:', listToArray(reverseFunction(test3)));
    console.log('Expected: []\n');

    // Test Case 4: Two nodes
    let test4 = createList([1, 2]);
    console.log('Test 4 - Two nodes:');
    console.log('Input:', listToArray(test4));
    console.log('Output:', listToArray(reverseFunction(test4)));
    console.log('Expected: [2, 1]\n');

    // Test Case 5: Nodes with negative values
    let test5 = createList([-1, 0, 1, -2, 2]);
    console.log('Test 5 - Negative values:');
    console.log('Input:', listToArray(test5));
    console.log('Output:', listToArray(reverseFunction(test5)));
    console.log('Expected: [2, -2, 1, 0, -1]\n');
}

// Run tests for both implementations
runTests(ReverseList, "In-place Solution (原地解法)");
runTests(ReverseListStack, "Stack-based Solution (基于栈的解法)");