const pushStack: (number|undefined)[] = []
const popStack: (number|undefined)[] = []

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 
 * @param node int整型 
 * @return 无
 */
export function push(node: number) {
    pushStack.push(node)
}

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 
 * @param 无 
 * @return int整型
 */
export function pop(): (number|undefined) {
    if(!popStack.length){
        while(pushStack.length){
            popStack.push(pushStack.pop())
        }
    }

    return popStack.pop()
}