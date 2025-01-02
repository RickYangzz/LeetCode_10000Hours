package BM43_包含min函数的栈.java_solutions;

import java.util.Stack;

public class Solution {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    public void push(int node) {
        stack.push(node);

        if (minStack.isEmpty() || minStack.peek() > node) {
            minStack.push(node);
        } else {
            Integer currentMin = minStack.peek();
            minStack.push(currentMin);
        }
    }

    public int pop() {
        minStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
