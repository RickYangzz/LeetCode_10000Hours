/**
 * 双指针解法
 * 
 * 好吧，看的题解 (左右指针)
 * https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode-solution-tuvc/
 * 
 * 看完题解，自己把代码写一遍，期望能提高对双指针的理解。
 * 
 * 
 * 推理：指针规律移动，逐一寻找每个下标存水量的特点。
 * 
 * 
 * 指针移动规律：
 * 1. 左侧大的时候，右侧移动。
 * 2. 右侧打的时候，左侧移动。
 * 
 * 终止条件：
 * 1. 两个指针相遇的时候。
 * 
 * 指针移动到每个位置的存水量规律：
 * 1. 左侧比右侧大的时候，计算右侧。右侧i存水量 = 右侧最大高度 - 右侧i的高度
 * 2. 左侧比右侧小的时候，计算左侧。左侧i存水量 = 左侧最大高度 - 左侧i的高度
 * 3. 左右相等的时候，选择计算左侧或者右侧都可以
 * 
 * 下次遇到双指针，再逐步推理吧(有时间开一个双指针专题训练)
 * https://blog.csdn.net/pushup8/article/details/85071735
 * 
 * 解决双指针问题三种常用思想：
 * - 左右指针：需要两个指针，一个指向开头，一个指向末尾，然后向中间遍历，直到满足条件或者两个指针相遇
 * - 快慢指针：需要两个指针，开始都指向开头，根据条件不同，快指针走得快，慢指针走的慢，直到满足条件或者快指针走到结尾
 * - 后序指针：常规指针操作是从前向后便利，对于合并和替换类型题，防止之前的数据被覆盖，双指针需从后向前便利
 * 
 */

/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
    if(!Array.isArray(height)) return 0;
    if(height.length < 3) return 0;

    let result = 0;
    let leftPointer = 0;
    let rightPointer = height.length-1;
    let leftMaxHeight = height[leftPointer];
    let rightMaxHeight = height[rightPointer];


    while(leftPointer < rightPointer) {
        if(height[leftPointer] > height[rightPointer]) {
            const waterSize = rightMaxHeight - height[rightPointer];
            result += Math.max(waterSize, 0);
            rightPointer--;
            rightMaxHeight = Math.max(rightMaxHeight, height[rightPointer]);
        }
        if(height[leftPointer] <= height[rightPointer]) {
            const waterSize = leftMaxHeight - height[leftPointer];
            result += Math.max(waterSize, 0);
            leftPointer++;
            leftMaxHeight = Math.max(leftMaxHeight, height[leftPointer]);
        }
    }

    return result;
};


// ******************************************* test **
const height = [4,2,0,3,2,5]
const result = trap(height);
console.log(result == 9)