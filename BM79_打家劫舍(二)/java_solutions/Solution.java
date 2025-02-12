
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param nums int整型一维数组 
     * @return int整型
     */
    public int rob (int[] nums) {
        if(nums.length == 0) return 0;

        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        int res = 0;

        // 偷第一家
        dp[1] = nums[0];
        for (int i = 2; i < nums.length; i++) { // 排除掉最后一家
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        res = dp[nums.length - 1];

        // 不偷第一家
        dp[1] = 0;
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }

        return Math.max(res, dp[nums.length]);
    }
}