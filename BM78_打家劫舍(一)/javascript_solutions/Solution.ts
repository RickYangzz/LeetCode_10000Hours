/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 
 * @param nums int整型一维数组 
 * @return int整型
 */
export function rob(nums: number[]): number {
    if(nums.length == 0) return 0;

    const dp = new Array(nums.length + 1);
    dp[0] = 0;
    dp[1] = nums[0];

    for (let i = 2; i < dp.length; i++) {
        dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
    }

    return dp[nums.length];
}
