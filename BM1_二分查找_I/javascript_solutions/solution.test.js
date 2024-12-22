import { search } from './solution.js';

function runTest(nums, target, expected) {
    const result = search(nums, target);
    console.log(`Input array: [${nums}]`);
    console.log(`Target: ${target}`);
    console.log(`Expected: ${expected}, Got: ${result}`);
    console.log(`Test ${result === expected ? 'PASSED' : 'FAILED'}\n`);
}

// Test Case 1: Normal case - element exists
runTest([1, 2, 4, 4, 5], 4, 2);

// Test Case 2: Element not found
runTest([1, 2, 4, 4, 5], 3, -1);

// Test Case 3: Empty array
runTest([], 5, -1);

// Test Case 4: Single element - found
runTest([1], 1, 0);

// Test Case 5: Single element - not found
runTest([1], 2, -1); 