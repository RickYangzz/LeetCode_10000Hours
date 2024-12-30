/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 旋转数组
 * @param n int整型 数组长度
 * @param m int整型 右移距离
 * @param a int整型一维数组 给定数组
 * @return int整型一维数组
 */
export function solve(n: number, m: number, a: number[]): number[] {
    if (n == 0 || a.length == 0) return a;

    // 取模处理，避免不必要的多余移动
    m = m % n;
    if (m === 0) return a;

    // 三次反转法：整体反转 + 两部分分别反转
    reverse(a, 0, n - 1);     // 反转整个数组
    reverse(a, 0, m - 1);     // 反转前 m 个元素
    reverse(a, m, n - 1);     // 反转剩余的 n-m 个元素

    return a;
}

function reverse(a: number[], start: number, end: number) {
    while (start < end) {
        const temp = a[end];
        a[end] = a[start];
        a[start] = temp;

        start++
        end--
    }
}
