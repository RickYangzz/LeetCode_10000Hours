/**
 * 给定一个长度为 n 的数组 num 和滑动窗口的大小 size，找出所有滑动窗口中的最大值。
 * 
 * 例如:
 * 如果输入数组 {2,3,4,2,6,2,5,1} 及滑动窗口的大小 3，
 * 那么一共存在 6 个滑动窗口，
 * 它们的最大值分别为 {4,4,6,6,6,5}。
 * 
 * 针对数组 {2,3,4,2,6,2,5,1} 的滑动窗口有以下 6 个：
 * {[2,3,4],2,6,2,5,1}，
 * {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}，
 * {2,3,4,2,6,[2,5,1]}。
 * 
 * 注意：
 * 1. 如果滑动窗口的大小为 0 或大于数组长度，返回空数组。
 * 2. 使用双端队列（deque）来优化滑动窗口中最大值的查询效率。
 * 
 * @param num 数组，包含 n 个整数。
 * @param size 滑动窗口的大小。
 * @return 返回包含每个滑动窗口最大值的数组。
 */
export function maxInWindows(num: number[], size: number): number[] {
    // 边界情况处理
    if (num.length === 0 || size === 0 || size > num.length) return [];
    if (size == 1) return num;

    const res: number[] = []; // 存储每个滑动窗口的最大值
    const deque: number[] = []; // 双端队列，用于存储窗口中的索引（保持递减顺序）

    // 遍历数组
    for (let index = 0; index < num.length; index++) {
        // 移除队列尾部小于当前值的元素索引，保持队列递减
        while (deque.length > 0 && num[deque[deque.length - 1]] < num[index]) {
            deque.pop();
        }

        // 将当前索引加入队列
        deque.push(index);

        const windowStart = index + 1 - size;

        // 移除队列中不在当前滑动窗口范围的索引
        while (deque.length > 0 && deque[0] < windowStart) {
            deque.shift();
        }

        // 当前索引形成一个完整窗口后，将队列头部的最大值加入结果
        if (deque.length > 0 && windowStart >= 0) {
            res.push(num[deque[0]]);
        }
    }

    return res;
}
