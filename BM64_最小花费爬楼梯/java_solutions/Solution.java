package BM64_最小花费爬楼梯.java_solutions;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param cost int整型一维数组 
     * @return int整型
     */
    public int minCostClimbingStairs (int[] cost) {
        
        for (int i = cost.length-3; i >= 0; i--) {
            cost[i] = Math.min(cost[i+1], cost[i+2]) + cost[i];
        }

        return Math.min(cost[0], cost[1]);
    }
}