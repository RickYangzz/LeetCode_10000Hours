/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 最少货币数
 * @param arr int整型一维数组 the array
 * @param aim int整型 the target
 * @return int整型
 */
export function minMoney(arr: number[], aim: number): number {
    const dp = new Array(aim + 1).fill(aim+1);
    dp[0] = 0;

    for (let i = 1; i < dp.length; i++) {
        for (const price of arr) {
            if(price <= i){
                dp[i] = Math.min(dp[i], dp[i - price] + 1);
            }
        }
    }

    return dp[aim] > aim ? -1 : dp[aim];
}
