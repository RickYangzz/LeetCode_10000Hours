package BM44_有效括号序列.java_solutions;

import java.util.*;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid(String s) {
        if (s.equals("")) return true;

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                stack.push(')');
                continue;
            }
            if (c == '{') {
                stack.push('}');
                continue;
            }
            if (c == '[') {
                stack.push(']');
                continue;
            }

            if (stack.isEmpty() || stack.pop() != c)
                return false;
        }

        return stack.isEmpty();
    }
}