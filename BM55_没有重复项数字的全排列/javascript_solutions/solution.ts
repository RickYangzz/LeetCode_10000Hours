/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 
 * @param num int整型一维数组 
 * @return int整型二维数组
 */
export function permute(num: number[]): number[][] {
    const result: number[][] = [];

    recursion(result, num, 0);

    return result;
}

function recursion(container: number[][], numbers: number[], index: number): void{
    if(index == numbers.length-1) {
        container.push([...numbers]);
    }else{
        for (let i = index; i < numbers.length; i++) {
            move(numbers, i, index);
            recursion(container, numbers, index+1);
            back(numbers, i, index);
        }
    }
}

function move(numbers: number[], i: number, index: number){
    const targetNum = numbers.splice(i,1);
    numbers.splice(index, 0, targetNum[0]);
}

function back(numbers: number[], i: number, index: number){
    const targetNum = numbers.splice(index, 1);
    numbers.splice(i, 0, targetNum[0]);
}