/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 验证IP地址
 * @param IP string字符串 一个IP地址字符串
 * @return string字符串
 */
export function solve(IP: string): string {
    if (isIPv4(IP)) return "IPv4";
    if (isIPv6(IP)) return "IPv6";

    return "Neither";
}

/**
 * IPv4 地址由十进制数和点来表示，每个地址包含4个十进制数，其范围为 0 - 255， 用(".")分割。
 * 比如，172.16.254.1；
 * 
 * 同时，IPv4 地址内的数不会以 0 开头。
 * 比如，地址 172.16.254.01 是不合法的。
 * 
 * @param IP 
 * @return
 */
function isIPv4(IP: string): boolean {
    if (!IP.includes(".")) return false;

    const arr = IP.split('.');
    if(arr.length != 4) return false;

    for (const subString of arr) {
        if (subString.length == 0 || subString.length > 3) return false;
        if (subString.length > 1 && subString.startsWith("0")) return false;

        let value = 0;
        for (const c of subString.split("")) {
            if (
                c.charCodeAt(0) < "0".charCodeAt(0) ||
                c.charCodeAt(0) > "9".charCodeAt(0)
            ) return false;

            value = value * 10 + (c.charCodeAt(0) - "0".charCodeAt(0))
            if (value < 0 || value > 255) return false;
        }
    }

    return true;
}


/**
 * IPv6 地址由8组16进制的数字来表示，每组表示 16 比特。这些组数字通过 (":")分割。
 * 比如,  2001:0db8:85a3:0000:0000:8a2e:0370:7334 是一个有效的地址。
 * 而且，我们可以加入一些以 0 开头的数字，字母可以使用大写，也可以是小写。
 * 所以， 2001:db8:85a3:0:0:8A2E:0370:7334 也是一个有效的 IPv6 address地址 (即，忽略 0 开头，忽略大小写)。
 * 
 * 然而，我们不能因为某个组的值为 0，而使用一个空的组，以至于出现 (::) 的情况。 
 * 比如， 2001:0db8:85a3::8A2E:0370:7334 是无效的 IPv6 地址。
 * 
 * 同时，在 IPv6 地址中，多余的 0 也是不被允许的。
 * 比如， 02001:0db8:85a3:0000:0000:8a2e:0370:7334 是无效的。
 * 
 * @param IP
 * @return
 */
function isIPv6(IP: string): boolean {
    if(!IP.includes(':')) return false;

    const arr = IP.split(':');

    if(arr.length != 8) return false;

    for (const subString of arr) {
        if(subString.length>4 || subString.length==0) return false;

        for (const c of subString.split("")) {
            if(!isHexChar(c)) return false;
        }
    }

    return true;
}

function isHexChar(c: string){
    const charCode = c.charCodeAt(0);

    const boolean09 = charCode >= "0".charCodeAt(0) && charCode <= "9".charCodeAt(0);
    const booleanaf = charCode >= "a".charCodeAt(0) && charCode <= "f".charCodeAt(0);
    const booleanAF = charCode >= "A".charCodeAt(0) && charCode <= "F".charCodeAt(0); 
    
    return boolean09 || booleanaf || booleanAF;
}


