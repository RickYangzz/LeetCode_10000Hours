package BM86_大数加法.java_solutions;

public class Solution {
    /**
     * 以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
     *
     * 计算两个数之和
     * 
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve(String s, String t) {
        if(s == null || s.length() == 0) return t;
        if(t == null || t.length() == 0) return s;

        int sLength = s.length();
        int tLength = t.length();

        StringBuilder stringBuilder = new StringBuilder();

        int carry = 0;
        for (int i = 1; i <= Math.max(sLength, tLength); i++) {
            int a = sLength - i >= 0 ? (s.charAt(sLength - i) - '0') : 0;
            int b = tLength - i >= 0 ? (t.charAt(tLength - i) - '0') : 0;

            int sum = a + b + carry;
            int value = sum % 10;
            carry = sum / 10;

            stringBuilder.append(value);
        }

        if(carry > 0) {
            stringBuilder.append("1");
        }

        return stringBuilder.reverse().toString();
    }
}