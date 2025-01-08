package BM84_最长公共前缀.java_solutions;

public class Solution {
    /**
     * 给你一个大小为 n 的字符串数组 strs ，其中包含n个字符串 ,
     * 编写一个函数来查找字符串数组中的最长公共前缀，返回这个公共前缀。
     * 
     * @param strs string字符串一维数组
     * @return string字符串
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";

        String result = strs[0];

        for (String string : strs) {
            result = getCommonPrefix(result, string);
        }

        return result;
    }

    private String getCommonPrefix(String first, String second) {
        Integer length = Math.min(first.length(), second.length());

        Integer end = 0;
        while (end < length &&
                first.charAt(end) == second.charAt(end)) {
            end++;
        }

        return first.substring(0, end);
    }
}