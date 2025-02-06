/**
 * 请写一个整数计算器，支持加减乘三种运算和括号。
 *
 * 返回表达式的值
 * @param s string字符串 待计算的表达式
 * @return int整型
 */
export function solve(s: string): number {
    const zeroCode = '0'.charCodeAt(0);
    const nineCode =  '9'.charCodeAt(0);
    const leftCode = '('.charCodeAt(0);
    const rightCode = ')'.charCodeAt(0);
    const plusCode = '+'.charCodeAt(0);
    const minusCode = '-'.charCodeAt(0);
    const timesCode = '*'.charCodeAt(0);

    const stack: number[] = [];
    let lastOperate = plusCode;
    let num = 0;

    for (let index = 0; index < s.length; index++) {
        let current = s.charCodeAt(index);

        if(zeroCode <= current && current <= nineCode){
            num = num*10 + (current - zeroCode);
            if(index != s.length-1) continue;
        }

        if(current == leftCode){
            let subStr = "";
            let leftTime = 1;
            index++; // 跳过当前左括号

            for (; index < s.length; index++) {
                current = s.charCodeAt(index);
                if(current == leftCode){
                    leftTime += 1;
                }else if (current == rightCode){
                    leftTime -= 1;
                    if(leftTime == 0) break;
                }
                subStr += s.charAt(index);
            }

            num = solve(subStr);
            if(index != s.length - 1) continue;
        }

        switch (lastOperate) {
            case plusCode:
                stack.push(num);
                break;
            case minusCode:
                stack.push(-num);
                break;
            case timesCode:
                const top = stack.pop();
                if(!top) throw new Error('input data error');
                stack.push(top * num);
                break;
        }

        num = 0;

        if(current == rightCode) {
            continue;
        }else{
            lastOperate = current;
        }
    }

    return stack.reduce((acc, curr) => acc + curr, 0);
}
