
const stack: number[] = [];
const minStack: number[] = [];

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 
 * @param value int整型 
 * @return 无
 */
export function push(value: number) {
    stack.push(value);

    if (!minStack.length || minStack[minStack.length -1] > value) {
        minStack.push(value);
    } else {
        const currentMin = minStack[minStack.length -1];
        minStack.push(currentMin);
    }
}

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 
 * @param 无 
 * @return 无
 */
export function pop() {
    minStack.pop();
    return stack.pop();
}

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 
 * @param 无 
 * @return int整型
 */
export function top(): number {
    return stack[stack.length -1];
}

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 
 * @param 无 
 * @return int整型
 */
export function min(): number {
    return minStack[minStack.length -1];
}