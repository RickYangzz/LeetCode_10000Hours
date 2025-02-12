
export function rob(nums: number[]): number {
    if(nums.length == 0) return 0;

    const dp = new Array(nums.length + 1);
    dp[0] = 0;

    // 偷第一家
    dp[1] = nums[0];
    for (let i = 2; i < nums.length; i++) {
        dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
    }
    const first = dp[nums.length - 1];

    // 不偷第一家
    dp[1] = 0;
    for (let i = 2; i <= nums.length; i++) {
        dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
    }

    return Math.max(first, dp[nums.length]);
}
