/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 
 * @param s string字符串 
 * @param n int整型 
 * @return string字符串
 */
export function trans(s: string, n: number): string {
    const stack: string[] = [];
    let word = "";

    for (const element of s) {
        const letter = element;
        if(letter == " ") {
            if(word){
                stack.push(word);
                word = "";
            }
            stack.push(letter);
        } else {
            word += convertCase(letter);
        }
    }

    if(word) stack.push(word);

    return stackPopString(stack);
}

function isUpperCase(char) {
    return char >= 'A' && char <= 'Z';
}

function isLowerCase(char) {
    return char >= 'a' && char <= 'z';
}

function convertCase(char: string){
    if(isUpperCase(char)) return char.toLowerCase();
    if(isLowerCase(char)) return char.toUpperCase();

    return " ";
}

function stackPopString(stack: string[]){
    let result = "";
    while(stack.length) {
        result+=stack.pop();
    }
    return result;
}
