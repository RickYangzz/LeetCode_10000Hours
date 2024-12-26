package BM55_没有重复项数字的全排列.java_solutions;

import java.util.*;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param num int整型一维数组 
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> permute (int[] num) {
        if(num.length == 1) {
            ArrayList<ArrayList<Integer>> container = new ArrayList<>();
            ArrayList<Integer> item = new ArrayList<>();
            item.add(num[0]);
            container.add(item);
            return container;
        }

        ArrayList<ArrayList<Integer>> container = new ArrayList<>();

        for(int index = 0; index < num.length; index++) {
            int[] subNum = removeElement(num, index);
            ArrayList<ArrayList<Integer>> subResult = permute(subNum);
            
            int firstNumber = num[index];
            subResult.forEach((ArrayList<Integer> item) -> {
                item.add(0, firstNumber);
            });

            container.addAll(subResult);
        }

        return container;
    }

    private int[] removeElement(int[] arr, int index) {
        // 检查下标是否合法
        if (index < 0 || index >= arr.length) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        // 创建新数组
        int[] newArr = new int[arr.length - 1];

        // 复制元素，跳过指定下标
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i != index) {
                newArr[j++] = arr[i];
            }
        }

        return newArr;
    }
}