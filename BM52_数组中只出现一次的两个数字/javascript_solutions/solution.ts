/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 
 * @param nums int整型一维数组 
 * @return int整型一维数组
 */
export function FindNumsAppearOnce(nums: number[]): number[] {
    let temp = 0;
    for (const n of nums) {
        temp ^= n
    }

    let k = 1;
    while ((k & temp) == 0) {
        k <<= 1;
    }

    let res1 = 0, res2 = 0;
    for (const n of nums) {
        if ((k & n) == 0) res1 ^= n;
        else res2 ^= n;
    }

    return res1 < res2 ? [res1, res2] : [res2, res1];
}
