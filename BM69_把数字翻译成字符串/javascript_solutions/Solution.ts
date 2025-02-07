/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 解码
 * @param nums string字符串 数字串
 * @return int整型
 */
export function solve(nums: string): number {
    if(nums == "0") return 0;
    if(nums.length == 1) return 1;

    const dp: number[] = new Array(nums.length + 1).fill(1);

    for (let i = 2; i <= nums.length; i++) {
        if(nums[i-1] == '0' && nums[i-2] != '1' && nums[i-2] != '2') return 0;

        if( nums[i-1] == '0' && (nums[i-2] == '1' || nums[i-2] == '2')){
            dp[i] = dp[i-2];
            continue;
        }

        if((nums[i-1] > '0' && nums[i-2] == "1") || (nums[i-1] > '0' && nums[i-2] == '2' && nums[i-1] < '7')){
            dp[i] = dp[i-1] + dp[i-2];
            continue;
        }

        dp[i] = dp[i-1]
    }

    return dp[nums.length];

}
