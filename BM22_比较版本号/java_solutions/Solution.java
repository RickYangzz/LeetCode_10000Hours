package BM22_比较版本号.java_solutions;

import java.util.*;


public class Solution {
    /**
     *  version1 > version2 返回1，如果 version1 < version2 返回-1，不然返回0.
     *
     * 比较版本号
     * @param version1 string字符串 
     * @param version2 string字符串 
     * @return int整型
     */
    public int compare (String version1, String version2) {
        int i = 0;
        int j = 0;

        while(i< version1.length() || j < version2.length()){
            int sum1 = 0;
            while (i < version1.length() && version1.charAt(i) != '.') {
                int value = version1.charAt(i) - '0';
                sum1 = sum1*10 + value;
                i++;
            }

            int sum2 = 0;
            while(j < version2.length() && version2.charAt(j) != '.'){
                int value = version2.charAt(j) - '0';
                sum2 = sum2*10 + value;
                j++;
            }

            if(sum1 > sum2) {
                return 1;
            }else if(sum1 < sum2){
                return -1;
            }

            i++;
            j++;
        }

        return 0;
    }
}