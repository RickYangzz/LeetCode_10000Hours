/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 
 * @param mat int整型二维数组 
 * @param n int整型 
 * @return int整型二维数组
 */
export function rotateMatrix(mat: number[][], n: number): number[][] {
    swap(mat);
    reverse(mat);
    return mat;
}

function swap(matrix: number[][]): void{
    for (let i = 0; i < matrix.length; i++) {
        for (let j = 0; j < i; j++) {
            const temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp; 
        }
    }
}

function reverse(matrix: number[][]): void{
    for (const element of matrix) {
        for (let j = 0; j < matrix.length/2; j++) {
            const temp = element[j];
            element[j] = element[matrix.length-j-1];
            element[matrix.length-j-1] = temp;
        }
    }
}