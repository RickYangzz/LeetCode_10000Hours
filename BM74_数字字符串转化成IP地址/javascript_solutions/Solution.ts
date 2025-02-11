/**
 * 现在有一个只包含数字的字符串，将该字符串转化成IP地址的形式，返回所有可能的情况。
 * 
 * @param s string字符串 
 * @return string字符串一维数组
 */
export function restoreIpAddresses(s: string): string[] {
    const result = [];
    // 如果字符串长度不合法，直接返回空结果
    if (s.length < 4 || s.length > 12) {
        return result;
    }

    recursive(s, 0, 0, result);

    return result;
}

const example: string[] = new Array<string>(4);

function recursive(s: string, step: number, index: number, result: string[]): void {
    if (step == 4) {
        if (index == s.length) {
            result.push(example.join('.'));
        }
        return;
    }

    let current = "";
    for (let i = index; i < s.length && i < index + 3; i++) {
        current += s[i];

        if (isIPNumber(current)) {
            example[step] = current;
            recursive(s, step + 1, i + 1, result);
        }
    }
}

function isIPNumber(current: string): boolean {
    return Number.parseInt(current) <= 255 && (current.length == 1 || current[0] != '0');
}
