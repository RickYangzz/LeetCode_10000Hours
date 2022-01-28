"use strict";
/**
 * 尾递归实现
 * 
 * 空间复杂度: 数组 O(n)
 * 时间复杂度: O(n)
 * 
 * 尾递归可以降低空间复杂度
 * 
 * https://zh.wikipedia.org/wiki/%E5%B0%BE%E8%B0%83%E7%94%A8
 * 
 * 三种 return
 *  第一种 go 收集leftMaxHeight
 *  第二种 back 收集result
 *  第三种 收集完毕，返回 result
 * 
 * 
 * https://www.ruanyifeng.com/blog/2015/04/tail-call.html
 * 只有在严格模式下，javascript才有尾调用消除功能。
 * leetcode 没有办法启用严格模式
 * https://ifront.net/article/89421bc6cc90f43fbc27117674d9ea1e
 *
 */

/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
    if(!Array.isArray(height)) return 0;
    if(height.length < 3) return 0;

    const leftMaxHeight = [height[0]]
    return bigFunction(height, leftMaxHeight, 1);
};

function bigFunction(height, leftMaxHeight, i, rightMaxHeight_before, result) {

    if(i === (height.length - 1) ) return backFunction(height, leftMaxHeight, i-1, height[i], 1);

    if(i === 0) return result - 1;

    if(result) return backFunction(height, leftMaxHeight, i, rightMaxHeight_before, result);

    return goFunction(height, leftMaxHeight, i);
}

function goFunction(height, leftMaxHeight, i) {

    leftMaxHeight[i] = Math.max( leftMaxHeight[i-1], height[i-1] ); 

    return bigFunction(height, leftMaxHeight, i+1);
}

function backFunction(height, leftMaxHeight, i, rightMaxHeight_before, result) {

    const rightMaxHeight_now = Math.max( rightMaxHeight_before, height[i+1]); 

    const waterSize = Math.min(leftMaxHeight[i], rightMaxHeight_now) - height[i];
    result += Math.max(waterSize, 0);

    return bigFunction(height, leftMaxHeight, i-1, rightMaxHeight_now, result);
}

// ******************************************* test **
const height = [0,1,0,2,1,0,1,3,2,1,2,1];
const result = trap(height);
console.log(result)