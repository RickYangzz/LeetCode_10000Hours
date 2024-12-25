package BM42_用两个栈实现队列.java_solutions;

public class SolutionTest {

    public static void main(String[] args) {
        testBetterSolution();
        testSolution();
    }

    // Test cases for BetterSolution
    public static void testBetterSolution() {
        System.out.println("Testing BetterSolution...");

        BetterSolution queue = new BetterSolution();
        
        // Test 1: Push and Pop with a single element
        queue.push(1);
        System.out.println(queue.pop() == 1 ? "Test passed!" : "Test failed!"); // Expected output: 1

        // Test 2: Push and Pop with multiple elements
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop() == 2 ? "Test passed!" : "Test failed!"); // Expected output: 2
        System.out.println(queue.pop() == 3 ? "Test passed!" : "Test failed!"); // Expected output: 3

        // Test 3: Pop from an empty queue (exception expected)
        try {
            queue.pop();
            System.out.println("Test failed!"); // Should not reach here
        } catch (Exception e) {
            System.out.println("Test passed!"); // Expected exception: Empty stack
        }

        // Test 4: Mixed push and pop
        queue.push(4);
        queue.push(5);
        queue.push(6);
        System.out.println(queue.pop() == 4 ? "Test passed!" : "Test failed!"); // Expected output: 4
        queue.push(7);
        System.out.println(queue.pop() == 5 ? "Test passed!" : "Test failed!"); // Expected output: 5
        System.out.println(queue.pop() == 6 ? "Test passed!" : "Test failed!"); // Expected output: 6
        System.out.println(queue.pop() == 7 ? "Test passed!" : "Test failed!"); // Expected output: 7
    }

    // Test cases for Solution
    public static void testSolution() {
        System.out.println("Testing Solution...");

        Solution queue = new Solution();
        
        // Test 1: Push and Pop with a single element
        queue.push(1);
        System.out.println(queue.pop() == 1 ? "Test passed!" : "Test failed!"); // Expected output: 1

        // Test 2: Push and Pop with multiple elements
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop() == 2 ? "Test passed!" : "Test failed!"); // Expected output: 2
        System.out.println(queue.pop() == 3 ? "Test passed!" : "Test failed!"); // Expected output: 3

        // Test 3: Pop from an empty queue (exception expected)
        try {
            queue.pop();
            System.out.println("Test failed!"); // Should not reach here
        } catch (Exception e) {
            System.out.println("Test passed!"); // Expected exception: Empty stack
        }

        // Test 4: Mixed push and pop
        queue.push(4);
        queue.push(5);
        queue.push(6);
        System.out.println(queue.pop() == 4 ? "Test passed!" : "Test failed!"); // Expected output: 4
        queue.push(7);
        System.out.println(queue.pop() == 5 ? "Test passed!" : "Test failed!"); // Expected output: 5
        System.out.println(queue.pop() == 6 ? "Test passed!" : "Test failed!"); // Expected output: 6
        System.out.println(queue.pop() == 7 ? "Test passed!" : "Test failed!"); // Expected output: 7
    }
}
