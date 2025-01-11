/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 *
 * @param cost int整型一维数组
 * @return int整型
 */
export function minCostClimbingStairs(cost: number[]): number {
    for (let index = 2; index < cost.length; index++) {
        cost[index] = Math.min(cost[index - 1], cost[index - 2]) + cost[index];
    }

    return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
}
