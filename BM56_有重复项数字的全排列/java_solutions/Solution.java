package BM56_有重复项数字的全排列.java_solutions;

import java.util.*;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param num int整型一维数组
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        Boolean[] used = new Boolean[num.length];
        Arrays.fill(used, false);

        recursion(result, num, temp, used);

        return result;
    }

    private void recursion(
        ArrayList<ArrayList<Integer>> result, 
        int[] num, 
        ArrayList<Integer> temp,
        Boolean[] used
    ) {
        if (temp.size() == num.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < num.length; i++) {
            if(used[i]) continue;

            if (i > 0 && num[i] == num[i - 1] && !used[i-1]) {
                continue;
            }

            temp.add(num[i]);
            used[i] = true;

            recursion(result, num, temp, used);

            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}