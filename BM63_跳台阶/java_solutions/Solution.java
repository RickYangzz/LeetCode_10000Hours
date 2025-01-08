package BM63_跳台阶.java_solutions;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param number int整型 
     * @return int整型
     */
    public int jumpFloor (int number) {
        int f1 = 1;
        int f2 = 2;
        if (number == 1) return f1;
        if(number == 2) return f2;

        int fn = 0;
        for (int i = 3; i <= number; i++) {
            fn = f2 + f1;

            f1 = f2;
            f2 = fn;
        }
        return fn;
    }
}