/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 
 * @param str1 string字符串 
 * @param str2 string字符串 
 * @return int整型
 */
export function editDistance(str1: string, str2: string): number {
    const dp = Array.from({length: str1.length + 1}, () => new Array(str2.length + 1));

    for (let i = 0; i <= str1.length; i++) {
        dp[i][0] = i;
    }
    for (let j = 0; j <= str2.length; j++) {
        dp[0][j] = j;
    }

    for (let i = 1; i <= str1.length; i++) {
        for (let j = 1; j <= str2.length; j++) {
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                dp[i][j] = dp[i-1][j-1];
            }else{
                dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
            }
        }
    }

    return dp[str1.length][str2.length];
}
