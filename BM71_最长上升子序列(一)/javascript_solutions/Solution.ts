/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 给定数组的最长严格上升子序列的长度。
 * @param arr int整型一维数组 给定的数组
 * @return int整型
 */
export function LIS(arr: number[]): number {
    if(arr.length == 0) return 0;
    if(arr.length == 1) return 1;

    let result = 0;
    const dp = new Array(arr.length).fill(1);
    for (let i = 1; i < arr.length; i++) {
        for (let j = 0; j < i; j++) {
            if(arr[j] < arr[i]){
                dp[i] = Math.max(dp[i], dp[j]+1);
                result = Math.max(result, dp[i])
            }
        }
    }

    return result;
}
