/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * longest common substring
 * @param str1 string字符串 the string
 * @param str2 string字符串 the string
 * @return string字符串
 */
export function LCS(str1: string, str2: string): string {
    const dp = Array.from({ length: str1.length + 1 }, () => new Array(str2.length + 1).fill(0));
    let max = 0;
    let position = 0;
    for (let i = 1; i <= str1.length; i++) {
        for (let j = 1; j <= str2.length; j++) {
            if (str1[i - 1] == str2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
            } else {
                dp[i][j] = 0;
            }

            if (dp[i][j] > max) {
                max = dp[i][j]
                position = i;
            }
        }
    }

    return str1.substring(position - max, position);
}
