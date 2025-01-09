let count = 0;

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 
 * @param nums int整型一维数组 
 * @return int整型
 */
export function InversePairs(nums: number[]): number {
    if (nums.length < 2) return 0;
    
    count = 0;

    mergeSort(nums, 0, nums.length - 1);

    return count;
}

function mergeSort(nums: number[], start: number, end: number): void {
    if (start >= end) return;

    const middle = Math.floor((start + end) / 2);

    mergeSort(nums, start, middle);
    mergeSort(nums, middle + 1, end);

    merge(nums, start, middle, end);
}

function merge(nums: number[], start: number, middle: number, end: number): void {
    const tempArr = new Array(end - start + 1);

    let i = 0;
    let l = start;
    let r = middle + 1;

    while (l <= middle && r <= end) {
        if (nums[l] <= nums[r]) {
            tempArr[i] = nums[l];
            i++;
            l++;
        } else {
            tempArr[i] = nums[r];

            count += middle - l + 1
            count %= 1000000007

            i++;
            r++;
        }
    }

    while (l <= middle) {
        tempArr[i] = nums[l];
        i++;
        l++;
    }

    while (r <= end) {
        tempArr[i] = nums[r];
        i++;
        r++;
    }

    for (let index = 0; index < tempArr.length; index++) {
        nums[start + index] = tempArr[index];
    }
}