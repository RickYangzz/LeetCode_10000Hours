/**
 * 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 *
 * 反转字符串
 * @param str string字符串 
 * @return string字符串
 */
export function solve(str: string): string {
    const strArr = str.split("");

    for (let index = 0; index < strArr.length/2; index++) {
        const temp = strArr[index];
        strArr[index] = strArr[strArr.length - index -1];
        strArr[strArr.length - index -1] = temp;
    }

    return strArr.join("");
}
