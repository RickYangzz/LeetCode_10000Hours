/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 
 * @param a int整型一维数组 
 * @param n int整型 
 * @param K int整型 
 * @return int整型
 */
export function findKth(a: number[], n: number, K: number): number {
    return quickSort(a, 0, n-1, K);
}

function quickSort(a: number[], low: number, high:number, k:number): number{
    const splitSpot = partition(a, low, high);

    if(splitSpot+1 == k) {
        return a[splitSpot];
    }else if(splitSpot + 1 < k) {
        return quickSort(a, splitSpot+1, high, k);
    }else{
        return quickSort(a, low, splitSpot-1, k);
    }
}

function partition(a: number[], low: number, high:number): number{
    const splitValue = a[low];
    while(low < high){
        while(low<high && a[high] < splitValue){
            high--;
        }
        a[low] = a[high];

        while(low<high && a[low] >= splitValue){
            low++;
        }
        a[high] = a[low];
    }
    a[low] = splitValue;

    return low;
}
