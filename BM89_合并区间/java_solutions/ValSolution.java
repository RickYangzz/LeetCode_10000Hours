package BM89_合并区间.java_solutions;

import java.util.*;

/**
 * 此方法不完善, 未通过该测试用例:
 * input: [[1,4],[0,0]]
 * expected: [[0,0],[1,4]]
 * output: [[0,4]]
 * 
 */
public class ValSolution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        int maxVal = 200000; // val的最大值
        int[] cover = new int[maxVal + 2]; // 用于标记区间的开始和结束

        // 标记区间
        for (Interval interval : intervals) {
            cover[interval.start]++; // 区间开始标记
            cover[interval.end + 1]--; // 区间结束标记
        }

        // 根据标记生成合并后的区间
        ArrayList<Interval> result = new ArrayList<>();
        int start = -1;
        int count = 0;

        for (int i = 0; i <= maxVal; i++) {
            count += cover[i]; // 累加覆盖数

            // 当前有覆盖
            if (count > 0) {
                if (start == -1) {
                    start = i; // 区间开始
                }
            } else {
                if (start != -1) {
                    result.add(new Interval(start, i - 1)); // 结束当前区间
                    start = -1; // 重置开始
                }
            }
        }

        return result;
    }
}
