package BM52_数组中只出现一次的两个数字.java_solutions;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param nums int整型一维数组 
     * @return int整型一维数组
     */
    public int[] FindNumsAppearOnce (int[] nums) {
        int temp = 0;
        for (int i : nums) {
            temp ^= i;
        }

        int k = 1;
        while( (k&temp) == 0){
            k <<= 1;
        }

        int res1 = 0, res2 = 0;
        for (int i : nums) {
            if((i & k)== 0) res1 ^= i;
            else res2 ^= i;
        }

        return (res1 > res2) ? new int[] {res2, res1} : new int[] {res1, res2};
    }
}