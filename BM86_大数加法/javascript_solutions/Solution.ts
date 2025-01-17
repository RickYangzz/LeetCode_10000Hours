/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 计算两个数之和
 * @param s string字符串 表示第一个整数
 * @param t string字符串 表示第二个整数
 * @return string字符串
 */
export function solve(s: string, t: string): string {
    if (s == null || s.length == 0) return t;
    if (t == null || t.length == 0) return s;

    const stringBuilder: string[] = [];

    let carry = 0;
    for (let index = 1; index <= Math.max(s.length, t.length); index++) {
        const a = s.length - index >= 0 ? Number.parseInt(s.charAt(s.length - index)) : 0;
        const b = t.length - index >= 0 ? Number.parseInt(t.charAt(t.length - index)) : 0;

        const sum = a + b + carry;
        carry = Math.floor(sum / 10);
        const value = sum % 10;

        stringBuilder.push(String(value));
    }

    if(carry > 0) {
        stringBuilder.push("1");
    }

    return stringBuilder.reverse().join("");
}
