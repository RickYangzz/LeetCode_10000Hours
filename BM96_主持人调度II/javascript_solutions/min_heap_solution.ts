/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 计算成功举办活动需要多少名主持人
 * @param n int整型 有n个活动
 * @param startEnd int整型二维数组 startEnd[i][0]用于表示第i个活动的开始时间，startEnd[i][1]表示第i个活动的结束时间
 * @return int整型
 */
export function minmumNumberOfHost(n: number, startEnd: number[][]): number {
    // 边界条件处理
    if (n === 0 || startEnd.length === 0) {
        return 0;
    }

    // 按活动的开始时间排序，若开始时间相同按结束时间排序
    startEnd.sort((a, b) => (a[0] === b[0] ? a[1] - b[1] : a[0] - b[0]));
    // 最小堆：存储活动的结束时间
    const minHeap = new MinHeap();

    for (const activity of startEnd) {
        // 检查最早结束的活动是否可以复用主持人
        if (minHeap.peek() !== null && activity[0] >= minHeap.peek()!) {
            minHeap.extractMin(); // 移除最早结束的活动
        }
        // 添加当前活动的结束时间
        minHeap.insert(activity[1]);
    }

    return minHeap.size();
}

class MinHeap {
    heap;

    constructor() {
        this.heap = [];
    }

    // 插入元素
    insert(val: number) {
        this.heap.push(val);
        this.bubbleUp();
    }

    // 删除最小值
    extractMin() {
        if (this.heap.length === 0) return null;
        if (this.heap.length === 1) return this.heap.pop();

        const min = this.heap[0];
        this.heap[0] = this.heap.pop();
        this.bubbleDown();
        return min;
    }

    // 查看最小值
    peek() {
        return this.heap[0] || null;
    }

    size(): number {
        return this.heap.length;
    }

    // 向上调整堆
    bubbleUp() {
        let index = this.heap.length - 1;
        while (index > 0) {
            const parentIndex = Math.floor((index - 1) / 2);
            if (this.heap[index] >= this.heap[parentIndex]) break;

            [this.heap[index], this.heap[parentIndex]] = [
                this.heap[parentIndex],
                this.heap[index],
            ];
            index = parentIndex;
        }
    }

    // 向下调整堆
    bubbleDown() {
        let index = 0;
        const length = this.heap.length;
        const element = this.heap[0];

        while (true) {
            let leftChildIndex = 2 * index + 1;
            let rightChildIndex = 2 * index + 2;
            let leftChild, rightChild;
            let swap: number | null = null;

            if (leftChildIndex < length) {
                leftChild = this.heap[leftChildIndex];
                if (leftChild < element) {
                    swap = leftChildIndex;
                }
            }

            if (rightChildIndex < length) {
                rightChild = this.heap[rightChildIndex];
                if (
                    (swap === null && rightChild < element) ||
                    (swap !== null && rightChild < leftChild)
                ) {
                    swap = rightChildIndex;
                }
            }

            if (swap === null) break;

            [this.heap[index], this.heap[swap]] = [
                this.heap[swap],
                this.heap[index],
            ];
            index = swap;
        }
    }
}
