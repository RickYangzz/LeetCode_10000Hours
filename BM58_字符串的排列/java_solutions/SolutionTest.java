package BM58_字符串的排列.java_solutions;

import java.util.ArrayList;

public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1：普通字符串
        String testStr1 = "abc";
        ArrayList<String> result1 = solution.Permutation(testStr1);
        System.out.println("Test Case 1 - Input: " + testStr1);
        System.out.println("Result: " + result1);

        // 测试用例 2：包含重复字符
        String testStr2 = "aab";
        ArrayList<String> result2 = solution.Permutation(testStr2);
        System.out.println("Test Case 2 - Input: " + testStr2);
        System.out.println("Result: " + result2);

        // 测试用例 3：单字符
        String testStr3 = "a";
        ArrayList<String> result3 = solution.Permutation(testStr3);
        System.out.println("Test Case 3 - Input: " + testStr3);
        System.out.println("Result: " + result3);

        // 测试用例 4：空字符串
        String testStr4 = "";
        ArrayList<String> result4 = solution.Permutation(testStr4);
        System.out.println("Test Case 4 - Input: \"" + testStr4 + "\"");
        System.out.println("Result: " + result4);

        // 测试用例 5：无输入（null）
        String testStr5 = null;
        ArrayList<String> result5 = solution.Permutation(testStr5);
        System.out.println("Test Case 5 - Input: null");
        System.out.println("Result: " + result5);
    }
}