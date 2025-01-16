/**
 * 
 * 输入一个长度为 n 字符串，打印出该字符串中字符的所有排列，你可以以任意顺序返回这个字符串数组。
 *
 * 
 * @param str string字符串 
 * @return string字符串一维数组
 */
export function Permutation(str: string): string[] {
    const strArr = str.split("").sort();
    const used: boolean[] = new Array(strArr.length).fill(false);
    const result: string[] = [];
    const strBuilder: string[] = [];
     
    recursion(result, strArr, strBuilder, used);

    return result;
}

function recursion(
    result: string[],
    strArr: string[],
    strBuilder: string[],
    used: boolean[]): void {

    if (strBuilder.length == strArr.length) {
        result.push(strBuilder.join(""));
        return;
    }

    for (let index = 0; index < strArr.length; index++) {
        if (used[index]) continue;
        if (index > 0 && strArr[index] == strArr[index - 1] && !used[index - 1]) continue;

        used[index] = true;
        strBuilder.push(strArr[index]);

        recursion(result, strArr, strBuilder, used);

        used[index] = false;
        strBuilder.pop();
    }
}