class ListNode {
    val: number
    next: ListNode | null
    constructor(val?: number, next?: ListNode | null) {
        this.val = (val === undefined ? 0 : val)
        this.next = (next === undefined ? null : next)
    }
}

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 
 * @param lists ListNode类一维数组 
 * @return ListNode类
 */
export function mergeKLists(lists: ListNode[]): ListNode | null {
    const res = new ListNode(-1);
    let head = res;

    const minHeap = new MinHeap();

    for (const node of lists) {
        minHeap.insert(node);
    }

    while (minHeap.size() > 0) {
        const minNode = minHeap.extractMin();

        head.next = minNode;
        head = minNode;

        minHeap.insert(minNode.next);
    }

    return res.next;
}


class MinHeap {
    heap;

    constructor() {
        this.heap = [];
    }

    // 插入元素
    insert(node: ListNode) {
        if (node === null) return; // 忽略 null 节点
        this.heap.push(node);
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
            if (this.heap[index].val >= this.heap[parentIndex].val) break;

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
        const element: ListNode | null = this.heap[0];
        if (!element) return; // 如果堆顶为空，直接返回

        while (true) {
            let leftChildIndex = 2 * index + 1;
            let rightChildIndex = 2 * index + 2;
            let leftChild: ListNode | null = null, rightChild: ListNode | null = null;
            let swap: number | null = null;

            if (leftChildIndex < length) {
                leftChild = this.heap[leftChildIndex];
                if (leftChild && leftChild.val < element.val) {
                    swap = leftChildIndex;
                }
            }

            if (rightChildIndex < length) {
                rightChild = this.heap[rightChildIndex];
                if (
                    (
                        swap === null && 
                        rightChild && 
                        rightChild.val < element.val
                    ) 
                    ||
                    (
                        swap !== null && 
                        leftChild && 
                        rightChild && 
                        rightChild.val < leftChild.val
                    )
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
