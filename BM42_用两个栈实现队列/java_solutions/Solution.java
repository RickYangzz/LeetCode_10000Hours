package BM42_用两个栈实现队列.java_solutions;

import java.util.Stack;

public class Solution {
    Stack<Integer> pushStack = new Stack<Integer>();
    Stack<Integer> popStack = new Stack<Integer>();
    
    public void push(int node) {
        while(!popStack.empty()) {
            pushStack.push(popStack.pop());
        }

        pushStack.push(node);
    }
    
    public int pop() {
        while(!pushStack.empty()) {
            popStack.push(pushStack.pop());
        }

        return popStack.pop();
    }
}
