/**
 * 对于我来说，这道题的动态规划体现在 每个下标左侧最大高度与右侧最大高度 可以由上一个下标推理而来，符合动态规划的特点。（"一个模型三个特征"）
 * 
 * 推理过程：
 * 在尝试推理之前，查看别的题解，知道两个条件：
 * 1. 以每个下标为单位，进行计算该单位可以承载的水量。
 * 2. 该单位可以承载的水量，由左侧最大高度与右侧最大高度决定。
 * 
 * 根据条件，第一个需要推理的是，假如知道左侧最大高度与右侧最大高度，如何求当前位置的水量。
 * 画了一组数组的图，总结规律。
 * indexWater = Min(leftMaxHeight, rightMaxHeight) - indexHeight
 * 
 * 接下来，需要知道每个下标的左侧最大高度与右侧最大高度。
 * 1. 粗暴的是，对于每个下标向左、向右遍历。
 * 2. 尝试思考高度如何推理。
 * 
 * 比较简单，很容易就可以想到从左侧开始遍历或者从右侧开始遍历。
 * 在此过程中，比较容易发现规律：
 * 1. 从左侧开始遍历
 *     i = 0 : leftMaxHeight(i) = 0
 *     leftMaxHeight(i) = Max( leftMaxHeight(i-1), height(i-1) )
 * 2. 对应的从右侧开始遍历
 *     i = n : rightMaxHeight(i) = 0
 *     rightMaxHeight(i) = Max( rightMaxHeight(i+1), height(i+1) )
 * 
 * 尝试编码：
 * 根据入参数组，求出两组数组，存储每个下标的左侧最大高度与右侧最大高度。
 * 然后再次遍历数据，求得每个下标可以存储的水量，累加得出结果.
 * 
 * 提前思考，总结过程与步骤。
 * 代码一步到位，不太需要重构了。
 */

/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
    if(!Array.isArray(height)) return 0;
    // 1. 求每个下标左侧最大高度
    const leftMaxHeight = getLeftMaxHeightArray(height);
    // 2. 求每个下标右侧最大高度
    const rightMaxHeight = getRightMaxHeightArray(height);
    // 3. 求数组的存水量
    return getAllWater(height, leftMaxHeight, rightMaxHeight);
};

const getLeftMaxHeightArray = (height) => {
    const leftMaxHeight = [];
    leftMaxHeight[0] = 0;
    for(let i = 1; i < height.length; i++) {
        leftMaxHeight[i] = Math.max( leftMaxHeight[i-1], height[i-1] );
    }
    return leftMaxHeight;
}

const getRightMaxHeightArray = (height) => {
    const rightMaxHeight = [];
    const n = height.length - 1;
    rightMaxHeight[n] = 0;
    for(let i = (n-1); i >= 0; i--) {
        rightMaxHeight[i] = Math.max( rightMaxHeight[i+1], height[i+1] );
    }
    return rightMaxHeight;
}

const getAllWater = (height, leftMaxHeight, rightMaxHeight) => {
    let result = 0;
    for(let i = 0; i < height.length; i++) {
        const waterSize = Math.min(leftMaxHeight[i], rightMaxHeight[i]) - height[i];
        result += Math.max(waterSize, 0);
    }
    return result;
}

// ******************************************* test **

const height = [0,1,0,2,1,0,1,3,2,1,2,1];
const result = trap(height);
console.log(result)