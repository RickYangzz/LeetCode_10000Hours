/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 比较版本号
 * @param version1 string字符串 
 * @param version2 string字符串 
 * @return int整型
 */
export function compare(version1: string, version2: string): number {
    const bool1 = version1 == null || version1.length == 0;
    const bool2 = version2 == null || version2.length == 0;
    if(bool1 && bool2) return 0;
    if(bool1) return -1;
    if(bool2) return 1;

    let i = 0;
    let j = 0;

    while(i< version1.length || j < version2.length){
        let sum1: number = 0;
        while(i < version1.length && version1.charAt(i) != '.') {
            let value = Number(version1.charAt(i));
            sum1 = sum1*10 + value;
            i++;
        }

        let sum2: number = 0;
        while(j < version2.length && version2.charAt(j) != '.'){
            const value = Number(version2.charAt(j));
            sum2 = sum2*10 + value;
            j++;
        }

        if (sum1 > sum2) return 1;
        if (sum1 < sum2) return -1;

        i++;
        j++;
    }

    return 0;
}
