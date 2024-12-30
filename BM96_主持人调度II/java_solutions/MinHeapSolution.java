package BM96_主持人调度II.java_solutions;

import java.util.*;

public class MinHeapSolution {
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

        // 按活动的开始时间排序，若开始时间相同按结束时间排序
        Arrays.sort(startEnd, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));

        // 准备最小堆辅助队列
        PriorityQueue<Integer> minHeap =  new PriorityQueue<>();

        // 遍历活动数组
        for (int[] item : startEnd) {
            // 检查最早结束的活动是否可以复用主持人
            if (minHeap.peek() != null && minHeap.peek() <= item[0]) {
                minHeap.poll();  // 移除最早结束的活动
            }
            // 添加当前活动的结束时间
            minHeap.offer(item[1]);
        }

        return minHeap.size();
    }
}

class StartEndComparator implements Comparator<int[]> {
    public int compare(int[] first, int[] second) {
        if(first[0] == second[0]) {
            if(first[1] > second[1]) return 1;
            else return -1;
        }

        if(first[0] > second[0]) return 1;
        else return -1;
    }
}
