package BM83_字符串变形.java_solutions;

import java.util.Stack;

public class BetterSolution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param s string字符串
     * @param n int整型
     * @return string字符串
     */
    public String trans(String s, int n) {
        Stack<String> transferStack = new Stack<>();
        StringBuilder word = new StringBuilder();
        char[] letters = s.toCharArray();
        
        for (char letter : letters) {
            if (letter == ' ') {
                if(word.length() > 0) {
                    transferStack.push(word.toString());
                    word.delete(0, word.length());
                }

                transferStack.push(Character.toString(letter));
            } else {
                char targetLetter = convertCase(letter);
                word.append(targetLetter);
            }
        }

        if(word.length() > 0) {
            transferStack.push(word.toString());
            word.delete(0, word.length());
        }

        StringBuilder result = new StringBuilder(n);
        while(!transferStack.isEmpty()){
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