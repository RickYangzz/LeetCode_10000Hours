package BM91_反转字符串.java_solutions;

public class Solution {
    /**
     * 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
     *
     * 反转字符串
     * @param str string字符串 
     * @return string字符串
     */
    public String solve (String str) {
        char[] strArr = str.toCharArray();
        int N = strArr.length;

        for (int i = 0; i < N/2; i++) {
            char temp = strArr[i];
            strArr[i] = strArr[N - i - 1];
            strArr[N - i - 1] = temp;
        }

        return new String(strArr);
    }
}