/**
 * 双指针解法
 * 
 * 好吧，看的题解
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
 * 下次遇到双指针，再逐步推理吧
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