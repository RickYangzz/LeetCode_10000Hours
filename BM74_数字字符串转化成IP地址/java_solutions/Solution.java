package BM74_数字字符串转化成IP地址.java_solutions;

import java.util.*;

public class Solution {
    private String[] example = new String[4];

    /**
     * 现在有一个只包含数字的字符串，将该字符串转化成IP地址的形式，返回所有可能的情况。
     * 
     * @param s string字符串
     * @return string字符串ArrayList
     */
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<>();

        recursive(s, 0, 0, result);

        return result;
    }

    private void recursive(String s, int step, int index, ArrayList<String> result) {
        if (step == 4) {
            if (index == s.length()) {
                result.add(String.join(".", example));
            }
            return;
        }

        String current = "";
        for (int i = index; i < s.length() && i < index + 3; i++) {
            current += s.charAt(i);

            if (isIPNumber(current)) {
                example[step] = current;
                recursive(s, step + 1, i + 1, result);
            }
        }
    }

    private boolean isIPNumber(String current){
        return Integer.parseInt(current) <= 255 && (current.length() == 1 || current.charAt(0) != '0');
    }
}