/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 
 * @param s string字符串 
 * @return bool布尔型
 */
export function isValid(s: string): boolean {
    const stack: string[] = [];

    for (const element of s.split("")) {
        if(element == '('){
            stack.push(')');
        }else if(element == "["){
            stack.push("]");
        }else if(element == "{"){
            stack.push("}");
        }else if( !stack.length || stack.pop() != element) {
            return false;
        }
    }

    return stack.length == 0;
}
