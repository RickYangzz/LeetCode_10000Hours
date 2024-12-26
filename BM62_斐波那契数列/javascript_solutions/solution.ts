/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 
 * @param n int整型 
 * @return int整型
 */
export function Fibonacci(n: number): number {
    if(n==1 || n==2) return 1;

    const record = [1,1];

    for (let index = 0; index <= n; index++) {
        record[index] = record[index-1] + record[index-2];
    }

    return record[n];
}
