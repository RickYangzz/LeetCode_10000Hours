/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 
 * @param num int整型一维数组 
 * @return int整型二维数组
 */
export function permuteUnique(num: number[]): number[][] {
    num.sort();
    const result: number[][] = [];
    const temp: number[] = [];
    const used: boolean[] = [];
    used.fill(false, 0, num.length);

    recursion(result, num, temp, used);

    return result;
}

function recursion(result: number[][], num: number[], temp: number[], used: boolean[]){
    if(temp.length == num.length) {
        result.push([...temp]);
        return;
    }

    for (let index = 0; index < num.length; index++) {
        if(used[index]) continue;

        if(index>0 && num[index] == num[index-1] && !used[index-1]) continue;

        used[index] = true;
        temp.push(num[index]);

        recursion(result, num, temp, used);

        used[index] = false;
        temp.pop()
    }

}
