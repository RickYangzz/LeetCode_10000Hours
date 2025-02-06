package BM49_表达式求值.java_solutions;

import java.util.*;

public class Solution {
    /**
     * 请写一个整数计算器，支持加减乘三种运算和括号。
     *
     * 返回表达式的值
     * 
     * @param s string字符串 待计算的表达式
     * @return int整型
     */
    public int solve(String s) {
        Stack<Integer> stack = new Stack<Integer>();

        char lastOperation = '+';
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            
            if ('0' <= current && current <= '9') {
                num = num * 10 + (current - '0');
                if(i != s.length() - 1) continue;
            }

            if (current == '(') {
                String subStr = "";
                int subQuestion = 0;

                for (; i < s.length(); i++) {
                    current = s.charAt(i);

                    if (current == '(') {
                        subQuestion += 1;
                    }

                    if (current == ')') {
                        subQuestion -= 1;
                        if (subQuestion == 0) break;
                    }

                    subStr += current;
                }

                num = this.solve(subStr.substring(1, subStr.length()));
                if(i != s.length() - 1) continue;
            }

            if (lastOperation == '+') {
                stack.push(num);
            }else if (lastOperation == '-') {
                stack.push(-num);
            }else if (lastOperation == '*') {
                Integer top = stack.pop();
                stack.push(top * num);
            }

            num = 0;

            // 右括号结束递归
            if(current == ')')
                continue;
            else
                lastOperation = current;
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}