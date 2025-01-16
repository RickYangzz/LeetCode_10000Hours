/**
 * 给定两个字符串str1和str2，输出两个字符串的最长公共子序列。
 * 如果最长公共子序列为空，则返回"-1"。
 * 假设目前给出的数据中，仅会存在一个最长的公共子序列。
 *
 * @param s1 string 字符串，第一个字符串
 * @param s2 string 字符串，第二个字符串
 * @return string 返回最长公共子序列；如果不存在，则返回"-1"
 */
export function LCS(s1: string, s2: string): string {
    // 边界条件检查
    if (s1 == null || s2 == null || s1.length === 0 || s2.length === 0) {
        return "-1";
    }

    // 初始化 dp 表和 direction 表
    const dp: number[][] = Array.from({ length: s1.length + 1 }, () => Array(s2.length + 1).fill(0));
    const direction: number[][] = Array.from({ length: s1.length + 1 }, () => Array(s2.length + 1).fill(0));

    // 填充 dp 表和 direction 表
    for (let i = 1; i <= s1.length; i++) {
        for (let j = 1; j <= s2.length; j++) {
            if (s1.charAt(i - 1) === s2.charAt(j - 1)) {
                dp[i][j] = dp[i - 1][j - 1] + 1; // 字符匹配，长度加 1
                direction[i][j] = 1; // 记录方向：来自左上
            } else if (dp[i][j - 1] > dp[i - 1][j]) {
                dp[i][j] = dp[i][j - 1]; // 选择左边的较大值
                direction[i][j] = 2; // 记录方向：来自左
            } else {
                dp[i][j] = dp[i - 1][j]; // 选择上面的较大值
                direction[i][j] = 3; // 记录方向：来自上
            }
        }
    }

    // 根据 direction 表还原最长公共子序列
    const result = buildLCS(direction, s1, s1.length, s2.length);

    // 如果结果为空，返回 "-1"
    return result || "-1";
}

/**
 * 根据方向表 direction 还原最长公共子序列
 *
 * @param direction number[][] 方向表，用于记录 dp 表中每个位置的转移方向
 * @param s1 string 原始字符串 s1，用于提取字符
 * @param i number 当前处于 s1 的第 i 个字符
 * @param j number 当前处于 s2 的第 j 个字符
 * @return string 最长公共子序列
 */
function buildLCS(direction: number[][], s1: string, i: number, j: number): string {
    const strBuilder: string[] = [];

    // 从后往前根据 direction 表还原 LCS
    while (i > 0 && j > 0) {
        if (direction[i][j] === 1) { // 来自左上角，字符匹配
            strBuilder.push(s1.charAt(i - 1)); // 将匹配的字符加入结果
            i--;
            j--;
        } else if (direction[i][j] === 2) { // 来自左
            j--;
        } else { // 来自上
            i--;
        }
    }

    // 因为是从后往前构造的结果，所以需要反转字符串
    return strBuilder.reverse().join("");
}