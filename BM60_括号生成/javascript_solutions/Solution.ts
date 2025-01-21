/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 
 * @param n int整型 
 * @return string字符串一维数组
 */
export function generateParenthesis(n: number): string[] {
    const result: string[] = [];

    recursion(result, 0, 0, n, "");

    return result;
}

function recursion(result: string[], left: number, right: number, n: number, temp: string){
    if(left == n && right == n) {
        result.push(temp);
        return;
    }

    if(left < n){
        recursion(result, left + 1, right, n, temp+"(");
    }

    if(right < n && right < left) {
        recursion(result, left, right + 1, n, temp + ")");
    }
}
