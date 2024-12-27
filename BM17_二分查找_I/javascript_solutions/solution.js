/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 * 
 * @param nums int整型一维数组 
 * @param target int整型 
 * @return int整型
 */
function search(nums, target) {
    if (!nums || nums.length === 0) return -1;
    
    let left = 0;
    let right = nums.length - 1;
    
    while (left <= right) {
        let mid = left + Math.floor((right - left) / 2);
        if (nums[mid] === target) {
            return mid;
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return -1;
}

export { search }; 