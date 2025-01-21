package BM60_括号生成.java_solutions;

import java.util.*;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param n int整型 
     * @return string字符串ArrayList
     */
    public ArrayList<String> generateParenthesis (int n) {
        ArrayList<String> result = new ArrayList<>();

        recursion(result, 0, 0, n, "");

        return result;
    }

    private void recursion( ArrayList<String> result, int left, int right, int n, String temp){
        if(left == n && right == n){
            result.add(temp);
            return;
        }

        if(left < n){
            recursion(result, left + 1, right, n, temp + "(");
        }

        if(right < n && right < left){
            recursion(result, left, right+1, n, temp + ")");
        }
    }
}