/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 计算成功举办活动需要多少名主持人
 * @param n int整型 有n个活动
 * @param startEnd int整型二维数组 startEnd[i][0]用于表示第i个活动的开始时间，startEnd[i][1]表示第i个活动的结束时间
 * @return int整型
 */
export function minmumNumberOfHost(n: number, startEnd: number[][]): number {
    // 边界条件处理
    if (n === 0 || startEnd.length === 0) {
        return 0;
    }

    // 使用解构赋值优化代码
    const startArr: number[] = startEnd.map(activity => activity[0]);
    const endArr: number[] = startEnd.map(activity => activity[1]);

    // 排序
    startArr.sort((a, b) => a - b);
    endArr.sort((a, b) => a - b);

    let host = 0, endIndex = 0;
    startArr.forEach(start => {
        if(start < endArr[endIndex]) host++;
        else endIndex++;
    })
    return host;
}
