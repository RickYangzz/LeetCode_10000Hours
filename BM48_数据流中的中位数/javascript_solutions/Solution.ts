const arr: number[] = [];

/**
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 
 * @param num int整型 
 * @return 无
 */
export function Insert(num: number) {
    if(arr.length > 0){
        let i = 0;
        for (const value of arr) {
            if(num >= value){
                break;
            }
            i++;
        }
        arr.splice(i, 0, num);
    }else{
        arr.push(num);
    }
}

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 
 * @param 无 
 * @return double浮点型
 */
export function GetMedian(): number {
    const size = arr.length;

    if(size%2 == 0){
        const first = arr[size/2];
        const second = arr[size/2 - 1];

        return (first + second) / 2;
    }else{
        return arr[Math.floor(size/2)];
    }
}