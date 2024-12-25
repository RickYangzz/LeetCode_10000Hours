/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 
 * @param numbers int整型一维数组 
 * @return int整型
 */
export function MoreThanHalfNum_Solution(numbers: number[]): number {
    let candidate = -1
    let count = 0

    for (const number of numbers) {
        if (count == 0) {
            candidate = number
        }

        if (candidate == number) {
            count++
        } else {
            count--
        }
    }

    count = 0
    for (const num of numbers) {
        if (num == candidate) count++
    }

    if (count > numbers.length / 2) return candidate
    return -1;
}
