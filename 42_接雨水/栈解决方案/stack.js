/**
 * 知道 （单调栈 + 遇到比当前元素小的就出栈） 可以解决这道题后，于是在纸上逐一入栈，尝试寻找规律。
 * 手写完一个个数组后，总结出一套公式。再次换一个数组，这次逐一用公式，尝试入栈出栈过程。
 * 在第二次入栈出站结束后，公式总结就趋于完善了。
 * 
 * 尝试编程，过程中犯了些小错误。
 * 主要原因是（数组加下标）这样的数据标识，自己很容易弄混。
 * 
 * 解决办法：多尝试尝试用变量名，逐一声明好要用的数据。然后再用声明好的变量名，编写代码逻辑。
 * 
 * 最后对代码测试、重构。提高代码的可理解性与可修改性。
 */

/**
 * @param {number[]} sourceArray
 * @return {number}
 */
var trap = function(sourceArray) {
    const stack = [];
    let result = 0;
    for(let i = 0; i < sourceArray.length; i++) {
        result += popLogic(stack, sourceArray, i);
        stack.push(i);
    }
    return result;
};


// 处理出栈的逻辑
const popLogic = (stack, sourceArray, i) => {
    let result = 0;
    while(stack.length && sourceArray[i] > sourceArray[stack[stack.length-1]]) {
        const pop = stack.pop();
        if(stack.length) {
            const left = stack[stack.length-1];
            result += calculateWaterSize(left, i, pop, sourceArray);
        }
    }
    return result;
}

// 计算水的尺寸
const calculateWaterSize = (left, right, bottom, sourceArray) => {
    const innerWidth = right - left - 1;
    const height = Math.min(sourceArray[left], sourceArray[right]);
    const innerHeight = height - sourceArray[bottom];
    return innerWidth * innerHeight;
}

const result = trap([0,1,0,2,1,0,1,3,2,1,2,1]);
console.log(result)