export function GetLeastNumbers_Solution(input: number[], k: number): number[] {
    // Edge case: if input is null, empty, or k is 0
    if (!input || input.length === 0 || k === 0) {
        return [];
    }

    // Edge case: if k is greater than or equal to the array length
    if (k >= input.length) {
        return input.sort((a, b) => a - b); // Sort the entire array and return
    }

    // Create a max-heap to store the smallest k elements
    const maxHeap = new MaxHeap();

    // Add the first k elements to the heap
    for (let i = 0; i < k; i++) {
        maxHeap.offer(input[i]);
    }

    // Process the remaining elements
    for (let i = k; i < input.length; i++) {
        if (input[i] < maxHeap.peek()) {
            maxHeap.poll(); // Remove the largest element in the heap
            maxHeap.offer(input[i]); // Add the new smaller element
        }
    }

    // Extract the elements from the heap into the result list
    const result: any[] = [];
    while (maxHeap.size() > 0) {
        result.push(maxHeap.poll());
    }

    // The elements in the heap are not sorted, so sort the result
    return result.sort((a, b) => a - b);
}

// Custom comparator for a max-heap
class MaxHeap {
    data;

    constructor() {
        this.data = [];
    }

    // Insert an element into the heap
    offer(val) {
        this.data.push(val);
        this._heapifyUp();
    }

    // Remove and return the maximum element from the heap
    poll() {
        if (this.size() === 1) return this.data.pop();
        const max = this.data[0];
        this.data[0] = this.data.pop();
        this._heapifyDown();
        return max;
    }

    // Peek at the maximum element in the heap
    peek() {
        return this.data[0];
    }

    size() {
        return this.data.length;
    }

    // Heapify up to maintain the max-heap property
    _heapifyUp() {
        let index = this.data.length - 1;
        while (index > 0) {
            const parentIndex = Math.floor((index - 1) / 2);
            if (this.data[parentIndex] >= this.data[index]) break;
            [this.data[parentIndex], this.data[index]] = [this.data[index], this.data[parentIndex]];
            index = parentIndex;
        }
    }

    // Heapify down to maintain the max-heap property
    _heapifyDown() {
        let index = 0;
        const length = this.data.length;
        while (true) {
            let leftChildIndex = 2 * index + 1;
            let rightChildIndex = 2 * index + 2;
            let largest = index;

            if (leftChildIndex < length && this.data[leftChildIndex] > this.data[largest]) {
                largest = leftChildIndex;
            }
            if (rightChildIndex < length && this.data[rightChildIndex] > this.data[largest]) {
                largest = rightChildIndex;
            }
            if (largest === index) break;
            [this.data[index], this.data[largest]] = [this.data[largest], this.data[index]];
            index = largest;
        }
    }
}
