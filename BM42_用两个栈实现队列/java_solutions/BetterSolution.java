package BM42_用两个栈实现队列.java_solutions;

import java.util.Stack;

public class BetterSolution {
    Stack<Integer> pushStack = new Stack<Integer>();
    Stack<Integer> popStack = new Stack<Integer>();

    public void push(int node) {
        pushStack.push(node);
    }

    public int pop() {
        if (popStack.empty()) {
            while (!pushStack.empty()) {
                popStack.push(pushStack.pop());
            }
        }

        return popStack.pop();
    }
}
