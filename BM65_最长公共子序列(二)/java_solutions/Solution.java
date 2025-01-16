public class Solution {
    /**
     * 给定两个字符串str1和str2，输出两个字符串的最长公共子序列。
     * 如果最长公共子序列为空，则返回"-1"。
     * 假设目前给出的数据中，仅会存在一个最长的公共子序列。
     *
     * @param s1 string字符串，第一个字符串
     * @param s2 string字符串，第二个字符串
     * @return string字符串，返回最长公共子序列；如果不存在，则返回"-1"
     */
    public String LCS(String s1, String s2) {
        // 边界条件检查：如果任意一个字符串为空，直接返回"-1"
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return "-1";
        }

        // 定义动态规划表 dp 和方向表 direction
        // dp[i][j] 表示 s1 的前 i 个字符和 s2 的前 j 个字符的最长公共子序列长度
        // direction[i][j] 用来记录从哪个方向转移到 dp[i][j]，用于后续还原路径
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int[][] direction = new int[s1.length() + 1][s2.length() + 1];

        // 填充 dp 表和 direction 表
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                // 如果当前字符匹配
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // 状态转移：长度加 1
                    direction[i][j] = 1; // 记录方向：来自左上角
                    continue;
                }

                // 如果当前字符不匹配，则选择较大的子问题结果
                if (dp[i][j - 1] > dp[i - 1][j]) {
                    dp[i][j] = dp[i][j - 1]; // 状态转移：来自左
                    direction[i][j] = 2; // 记录方向：来自左
                } else {
                    dp[i][j] = dp[i - 1][j]; // 状态转移：来自上
                    direction[i][j] = 3; // 记录方向：来自上
                }
            }
        }

        // 使用 direction 表还原最长公共子序列
        String result = buildLCS(direction, s1.length(), s2.length(), s1);

        // 如果结果为空，返回 "-1"，否则返回结果
        return result.isEmpty() ? "-1" : result;
    }

    /**
     * 根据方向表 direction 还原最长公共子序列
     *
     * @param direction 方向表，用于记录 dp 表中每个位置的转移方向
     * @param i 当前处于 s1 的第 i 个字符
     * @param j 当前处于 s2 的第 j 个字符
     * @param s1 原始字符串 s1，用于提取字符
     * @return 最长公共子序列的字符串
     */
    private String buildLCS(int[][] direction, int i, int j, String s1) {
        // 使用 StringBuilder 动态构造结果（因为字符串拼接效率低）
        StringBuilder strBuilder = new StringBuilder();

        // 根据方向表从后往前还原 LCS
        while (i > 0 && j > 0) {
            if (direction[i][j] == 1) { // 来自左上角，说明当前字符匹配
                strBuilder.append(s1.charAt(i - 1)); // 将匹配的字符加入结果
                i--; // 向左上角移动
                j--;
            } else if (direction[i][j] == 2) { // 来自左，移动到前一个字符
                j--;
            } else { // 来自上，移动到上一行
                i--;
            }
        }

        // 因为是从后往前构造的结果，所以需要反转字符串
        return strBuilder.reverse().toString();
    }
}