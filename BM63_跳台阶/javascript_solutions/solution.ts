/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 
 * @param number int整型 
 * @return int整型
 */
export function jumpFloor(number: number): number {
    if(number <= 1) return 1;

    let f0 = 1;
    let f1 = 1;
    let fn = 1;

    for (let index = 2; index <= number; index++) {
        fn = f0 + f1;

        f0 = f1;
        f1 = fn;
    }

    return fn;
}
