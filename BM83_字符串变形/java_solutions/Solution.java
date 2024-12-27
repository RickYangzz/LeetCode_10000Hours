package BM83_字符串变形.java_solutions;

import java.util.Stack;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param s string字符串
     * @param n int整型
     * @return string字符串
     */
    public String trans(String s, int n) {
        StringBuilder result = new StringBuilder(n);
        Stack<Character> transferStack = new Stack<>();
        
        char[] letters = s.toCharArray();
        for (int i = letters.length - 1; i > -1; i--) {
            char letter = letters[i];

            if (letter == ' ') {
                while (!transferStack.isEmpty()) {
                    result.append(transferStack.pop());
                }
                result.append(letter);
            } else {
                char targetLetter = convertCase(letter);
                transferStack.push(targetLetter);
            }
        }

        while (!transferStack.isEmpty()) {
            result.append(transferStack.pop());
        }

        return result.toString();
    }

    private char convertCase(char letter) {
        if (Character.isUpperCase(letter)) {
            return (Character.toLowerCase(letter));
        } else {
            return (Character.toUpperCase(letter));
        }
    }
}