package BM96_主持人调度II.java_solutions;

import java.util.*;

public class GreedySolution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 计算成功举办活动需要多少名主持人
     * @param n int整型 有n个活动
     * @param startEnd int整型二维数组 startEnd[i][0]用于表示第i个活动的开始时间，startEnd[i][1]表示第i个活动的结束时间
     * @return int整型
     */
    public int minmumNumberOfHost (int n, int[][] startEnd) {
        if (n == 0 || startEnd == null || startEnd.length == 0) {
            return 0;
        }

        // 使用原始数组来存储开始和结束时间
        int[] startArr = new int[n];
        int[] endArr = new int[n];

        for (int i = 0; i < n; i++) {
            startArr[i] = startEnd[i][0];
            endArr[i] = startEnd[i][1];
        }

        // 排序
        Arrays.sort(startArr);
        Arrays.sort(endArr);

        int host = 0;
        int endIndex = 0;
        for (int i = 0; i < n; i++) {
            // 判断当前活动是否需要新的主持人
            if (startArr[i] < endArr[endIndex]) {
                host++;  // 需要一个新主持人
            } else {
                endIndex++;  // 可以复用已有主持人
            }
        }

        return host;
    }
}
