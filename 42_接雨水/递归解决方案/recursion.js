/**
 * 递归实现
 * 
 * 理论支持：
 * 一切可以用动态规划实现的，都可以用递归实现
 * 
 * 推理过程：
 * 1. 思考从第一个下标开始，往后遍历，并且存储当前的leftMaxHeight与计算逻辑
 * 2. 当走到最后一个下标的时候，就可以回溯了。
 * 3. 在回溯过程中，不断收集上一层留下的leftMaxHeight与计算逻辑。
 * 4. 每一层累加，在当前层算出来的结果。
 * 5. 回溯结束，结果就可以计算出来了。
 * 
 * 编码过程：
 * 1. 从动态规划案例，总结所有需要的公式
 * 2. 利用代码模拟上述过程。
 * 3. 用结果测试。
 * 
 * 空间复杂度降为了O(1)
 * 时间复杂度为O(n)
 *
 */

/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
    if(!Array.isArray(height)) return 0;
    if(height.length < 3) return 0;
    return getAllWater(height, height[0], 1).result;
};

const getAllWater = (height, leftMaxHeight_before, i) => {
    if(i === (height.length - 1) ) return { rightMaxHeight_before: height[i], result: 0 }; // 终止，返回上一层。

    const leftMaxHeight_now = Math.max( leftMaxHeight_before, height[i-1] ); // 下钻准备，并当前层锁定该变量

    let { rightMaxHeight_before, result } = getAllWater(height, leftMaxHeight_now, i+1); // 进入下一层

    const rightMaxHeight_now = Math.max( rightMaxHeight_before, height[i+1] ); // 回溯结果
    
    // 结果累加
    const waterSize = Math.min(leftMaxHeight_now, rightMaxHeight_now) - height[i];
    result += Math.max(waterSize, 0);

    return {rightMaxHeight_before: rightMaxHeight_now, result}; // 返回上一层, 携带最终数据以及上一层需要的数据
}

// ******************************************* test **
const height = [0,1,0,2,1,0,1,3,2,1,2,1];
const result = trap(height);
console.log(result)