/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 
 * @param strs string字符串一维数组 
 * @return string字符串
 */
export function longestCommonPrefix(strs: string[]): string {
    if (strs.length == 0) return "";

    let result: string = strs[0];

    for (const string of strs) {
        result = getCommonPrefix(result, string);
    }

    return result;
}

function getCommonPrefix(first: string, second: string): string {
    const minLength = Math.min(first.length, second.length);

    let end = 0;
    while (
        end < minLength &&
        first.charAt(end) == second.charAt(end)
    ) {
        end++;
    }

    return first.substring(0, end);
}
